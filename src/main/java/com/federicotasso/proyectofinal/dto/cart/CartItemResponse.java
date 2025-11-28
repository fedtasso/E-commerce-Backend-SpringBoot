package com.federicotasso.proyectofinal.dto.cart;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CartItemResponse {

  private Long id;
  private Long productId;
  private String productTitle;
  private BigDecimal productPrice;
  private String productImage;
  private Integer quantity;
  private BigDecimal unitPrice;
  private BigDecimal subtotal;
}
