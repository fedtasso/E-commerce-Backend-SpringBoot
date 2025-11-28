package com.federicotasso.proyectofinal.service;

import com.federicotasso.proyectofinal.dto.cart.AddToCartRequest;
import com.federicotasso.proyectofinal.dto.cart.CartResponse;

public interface CartService {

  CartResponse getCartByUserId(Long userId);

  CartResponse addItemToCart(Long userId, AddToCartRequest request);

  CartResponse updateCartItem(Long userId, AddToCartRequest request);

  CartResponse removeItemFromCart(Long userId, Long itemId);

  CartResponse clearCart(Long userId);

  void deleteCartByUserId(Long userId);
}
