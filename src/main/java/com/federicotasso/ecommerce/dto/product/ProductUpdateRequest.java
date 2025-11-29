package com.federicotasso.ecommerce.dto.product;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductUpdateRequest {

  private String title;

  @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
  private BigDecimal price;

  private String category;

  @Min(value = 0, message = "El stock no puede ser negativo")
  private Integer stock;

  private String description;

  private String image;
}