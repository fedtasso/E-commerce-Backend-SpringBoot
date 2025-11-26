package com.federicotasso.proyectofinal.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductRequest {

  @NotBlank(message = "El título es obligatorio")
  private String title;

  @NotNull(message = "El precio es obligatorio")
  @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
  private BigDecimal price;

  @NotBlank(message = "La categoría es obligatoria")
  private String category;

  @NotNull(message = "El stock es obligatorio")
  @Min(value = 0, message = "El stock no puede ser negativo")
  private Integer stock;

  private String description;
  
  private String image;
}