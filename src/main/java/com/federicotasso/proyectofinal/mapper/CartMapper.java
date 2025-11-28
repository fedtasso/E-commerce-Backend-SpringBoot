package com.federicotasso.proyectofinal.mapper;

import com.federicotasso.proyectofinal.dto.cart.CartItemResponse;
import com.federicotasso.proyectofinal.dto.cart.CartResponse;
import com.federicotasso.proyectofinal.model.Cart;
import com.federicotasso.proyectofinal.model.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {

  @Mapping(target = "userId", source = "user.id")
  @Mapping(target = "userName", source = "user.name")
  @Mapping(target = "items", source = "items")
  CartResponse toResponse(Cart cart);

  @Mapping(target = "productId", source = "product.id")
  @Mapping(target = "productTitle", source = "product.title")
  @Mapping(target = "productPrice", source = "product.price")
  @Mapping(target = "productImage", source = "product.image")
  CartItemResponse toItemResponse(CartItem cartItem);
}