package com.federicotasso.proyectofinal.controller;

import com.federicotasso.proyectofinal.dto.cart.AddToCartRequest;
import com.federicotasso.proyectofinal.dto.cart.CartResponse;
import com.federicotasso.proyectofinal.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {

  private final CartService cartService;

  @GetMapping("/user/{userId}")
  public ResponseEntity<CartResponse> getCartByUserId(@PathVariable Long userId) {
    CartResponse cart = cartService.getCartByUserId(userId);
    return ResponseEntity.ok(cart);
  }

  @PostMapping("/user/{userId}/items")
  public ResponseEntity<CartResponse> addItemToCart(
      @PathVariable Long userId,
      @Valid @RequestBody AddToCartRequest request) {
    CartResponse cart = cartService.addItemToCart(userId, request);
    return ResponseEntity.ok(cart);
  }

  @PutMapping("/user/{userId}/items")
  public ResponseEntity<CartResponse> updateCartItem(
      @PathVariable Long userId,
      @Valid @RequestBody AddToCartRequest request) {
    CartResponse cart = cartService.updateCartItem(userId, request);
    return ResponseEntity.ok(cart);
  }

  @DeleteMapping("/user/{userId}/items/{productId}")
  public ResponseEntity<CartResponse> removeItemFromCart(
      @PathVariable Long userId,
      @PathVariable Long productId) {
    CartResponse cart = cartService.removeItemFromCart(userId, productId);
    return ResponseEntity.ok(cart);
  }

  @DeleteMapping("/user/{userId}/clear")
  public ResponseEntity<CartResponse> clearCart(@PathVariable Long userId) {
    CartResponse cart = cartService.clearCart(userId);
    return ResponseEntity.ok(cart);
  }
}
