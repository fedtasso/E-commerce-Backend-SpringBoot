package com.federicotasso.ecommerce.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Data;

@Entity
@Table(name = "carts")
@Data
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CartItem> items = new ArrayList<>();

  @Column(name = "total_price", precision = 10, scale = 2) //columnDefinition = "DECIMAL(10,2)"
  private BigDecimal totalPrice = BigDecimal.ZERO;

  @Column(name = "total_items")
  private Integer totalItems = 0;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
    updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = LocalDateTime.now();
  }

  // Métodos helper
  public void calculateTotals() {
    this.totalItems = items.stream()
        .mapToInt(CartItem::getQuantity)
        .sum();

    this.totalPrice = items.stream()
        .map(CartItem::getSubtotal)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  public void addItem(CartItem newItem) {
    Optional<CartItem> existingItem = items.stream()
        .filter(item -> item.getProduct().getId().equals(newItem.getProduct().getId()))
        .findFirst();

    if (existingItem.isPresent()) {
      CartItem item = existingItem.get();
      item.setQuantity(item.getQuantity() + newItem.getQuantity());
    } else {
      items.add(newItem);
    }
    calculateTotals();
  }

  public void removeItem(CartItem item) {
    items.remove(item);
    calculateTotals();
  }

  public void clearCart() {
    items.clear();
    calculateTotals();
  }

}