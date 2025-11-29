package com.federicotasso.ecommerce.mapper;

import com.federicotasso.ecommerce.dto.cart.CartItemResponse;
import com.federicotasso.ecommerce.dto.cart.CartResponse;
import com.federicotasso.ecommerce.model.Cart;
import com.federicotasso.ecommerce.model.CartItem;
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