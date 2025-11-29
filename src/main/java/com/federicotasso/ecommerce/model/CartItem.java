package com.federicotasso.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Entity
@Table(name = "cart_items")
@Data
public class CartItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "cart_id", nullable = false)
  private Cart cart;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @Column(nullable = false)
  private Integer quantity = 0;

  @Column(name = "unit_price", precision = 10, scale = 2, nullable = false)
  private BigDecimal unitPrice = BigDecimal.ZERO;

  @Column(name = "subtotal", precision = 10, scale = 2, nullable = false)
  private BigDecimal subtotal = BigDecimal.ZERO;

  @PrePersist
  @PreUpdate
  public void calculateSubtotal() {
    this.subtotal = unitPrice.multiply(BigDecimal.valueOf(quantity));
  }

  // Método para actualizar cantidad
  public void updateQuantity(Integer newQuantity) {
    this.quantity = newQuantity;
    calculateSubtotal();
  }
}
