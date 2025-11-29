package com.federicotasso.ecommerce.service;

import com.federicotasso.ecommerce.dto.cart.AddToCartRequest;
import com.federicotasso.ecommerce.dto.cart.CartResponse;

public interface CartService {

  CartResponse getCartByUserId(Long userId);

  CartResponse addItemToCart(Long userId, AddToCartRequest request);

  CartResponse updateCartItem(Long userId, AddToCartRequest request);

  CartResponse removeItemFromCart(Long userId, Long itemId);

  CartResponse clearCart(Long userId);

  void deleteCartByUserId(Long userId);
}
