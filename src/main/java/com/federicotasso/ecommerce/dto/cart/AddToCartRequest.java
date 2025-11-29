package com.federicotasso.ecommerce.dto.cart;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddToCartRequest {

  @NotNull(message = "El ID del producto es requerido")
  private Long productId;

  @NotNull(message = "La cantidad es requerida")
  @Min(value = 1, message = "La cantidad debe ser al menos 1")
  private Integer quantity;
}