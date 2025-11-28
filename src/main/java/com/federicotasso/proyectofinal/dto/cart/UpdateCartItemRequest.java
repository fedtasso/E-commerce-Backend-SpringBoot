package com.federicotasso.proyectofinal.dto.cart;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateCartItemRequest {

  @NotNull(message = "La cantidad es requerida")
  @Min(value = 1, message = "La cantidad debe ser al menos 1")
  private Integer quantity;
}
