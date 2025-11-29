package com.federicotasso.ecommerce.dto.cart;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class CartResponse {

  private Long id;
  private Long userId;
  private String userName;
  private List<CartItemResponse> items;
  private Integer totalItems;
  private BigDecimal totalPrice;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}