package com.federicotasso.ecommerce.service;

import com.federicotasso.ecommerce.dto.cart.AddToCartRequest;
import com.federicotasso.ecommerce.dto.cart.CartResponse;
import com.federicotasso.ecommerce.exception.business.ActiveCartNotFoundException;
import com.federicotasso.ecommerce.exception.business.ProductNotFoundException;
import com.federicotasso.ecommerce.exception.business.ProductNotInCartException;
import com.federicotasso.ecommerce.exception.business.UserNotFoundException;
import com.federicotasso.ecommerce.mapper.CartMapper;
import com.federicotasso.ecommerce.model.Cart;
import com.federicotasso.ecommerce.model.CartItem;
import com.federicotasso.ecommerce.model.Product;
import com.federicotasso.ecommerce.model.User;
import com.federicotasso.ecommerce.repository.CartItemRepository;
import com.federicotasso.ecommerce.repository.CartRepository;
import com.federicotasso.ecommerce.repository.ProductRepository;
import com.federicotasso.ecommerce.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

  private final CartRepository cartRepository;
  private final CartItemRepository cartItemRepository;
  private final UserRepository userRepository;
  private final ProductRepository productRepository;
  private final CartMapper cartMapper;

  @Override
  @Transactional(readOnly = true)
  public CartResponse getCartByUserId(Long userId) {
    Cart cart = cartRepository.findByUserIdWithItems(userId)
        .orElseThrow(() ->
            new ActiveCartNotFoundException(userId));
    return cartMapper.toResponse(cart);
  }

  @Override
  @Transactional
  public CartResponse addItemToCart(Long userId, AddToCartRequest request) {
    //verificar user y product
    User user = getUserOrThrow(userId);
    Product product = getProductOrThrow(request.getProductId());
    validateStock(product, request.getQuantity());

    //Obtener o crear carrito
    Cart cart = getOrCreateCart(user);

    // Verificar si el producto ya está en el carrito
    Optional<CartItem> existingItem = cartItemRepository.findByCartAndProduct(cart, product);

    if (existingItem.isPresent()) {
      // Si ya existe sumar o restar
      updateItemQuantity(existingItem.get(),
          existingItem.get().getQuantity() + request.getQuantity());
    } else {
      // si no crear nuevo item
      createNewCartItem(cart, product, request.getQuantity());
    }
    return updateCartTotals(cart);
  }

  @Override
  @Transactional
  public CartResponse updateCartItem(Long userId, AddToCartRequest request) {
    User user = getUserOrThrow(userId);
    Product product = getProductOrThrow(request.getProductId());
    validateStock(product, request.getQuantity());

    Cart cart = getCartByUserIdOrThrow(userId);

    CartItem cartItem = cartItemRepository.findByCartAndProduct(cart, product)
        .orElseThrow(() -> new RuntimeException("El producto no está en el carrito"));

    updateItemQuantity(cartItem, request.getQuantity());

    return updateCartTotals(cart);
  }

  @Override
  @Transactional
  public CartResponse removeItemFromCart(Long userId, Long productId) {
    User user = getUserOrThrow(userId);
    Product product = getProductOrThrow(productId);
    Cart cart = getCartByUserIdOrThrow(userId);

    CartItem cartItem = cartItemRepository.findByCartAndProduct(cart, product)
        .orElseThrow(() -> new ProductNotInCartException(productId));

    cartItemRepository.delete(cartItem);

    return updateCartTotals(cart);
  }

  @Override
  @Transactional
  public CartResponse clearCart(Long userId) {
    Cart cart = getCartByUserIdOrThrow(userId);

    cartItemRepository.deleteByCartId(cart.getId());
    cart.getItems().clear();

    return updateCartTotals(cart);
  }

  @Override
  @Transactional
  public void deleteCartByUserId(Long userId) {
    Cart cart = getCartByUserIdOrThrow(userId);
    cartRepository.delete(cart);
  }

  // ========== MÉTODOS DE CLASE ==========

  private User getUserOrThrow(Long userId) {
    return userRepository.findById(userId)
        .orElseThrow(
            () -> new UserNotFoundException(userId));
  }

  private Product getProductOrThrow(Long productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new ProductNotFoundException(productId));
  }

  private Cart getCartByUserIdOrThrow(Long userId) {
    return cartRepository.findByUserId(userId)
        .orElseThrow(
            () -> new ActiveCartNotFoundException(userId));
  }

  private Cart getOrCreateCart(User user) {
    return cartRepository.findByUser(user)
        .orElseGet(() -> {
          Cart newCart = new Cart();
          newCart.setUser(user);
          return cartRepository.save(newCart);
        });
  }

  private void validateStock(Product product, Integer quantity) {
    if (product.getStock() < quantity) {
      throw new RuntimeException(
          "Stock insuficiente para el producto: %s".formatted(product.getTitle()));
    }
  }

  private void updateItemQuantity(CartItem item, Integer newQuantity) {
    item.updateQuantity(newQuantity);
    cartItemRepository.save(item);
  }

  private void createNewCartItem(Cart cart, Product product, Integer quantity) {
    CartItem newItem = new CartItem();
    newItem.setCart(cart);
    newItem.setProduct(product);
    newItem.setQuantity(quantity);
    newItem.setUnitPrice(product.getPrice());
    newItem.calculateSubtotal();

    //guardar y actualizar
    cartItemRepository.save(newItem);
    cart.getItems().add(newItem);
  }

  private CartResponse updateCartTotals(Cart cart) {
    cart.calculateTotals();
    cartRepository.save(cart);
    return cartMapper.toResponse(cart);
  }

}
