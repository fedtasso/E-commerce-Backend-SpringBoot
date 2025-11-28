package com.federicotasso.proyectofinal.dto.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProductResponse {

  private Long id;
  private String title;
  private BigDecimal price;
  private String description;
  private String category;
  private String image;
  private Integer stock;
  private LocalDateTime createdAt;
}