package com.federicotasso.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 255)
  private String title;

  @Column(nullable = false, columnDefinition = "DECIMAL(10,2)")
  private BigDecimal price;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(nullable = false)
  private String category;

  private String image;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(nullable = false)
  private Integer stock;

}