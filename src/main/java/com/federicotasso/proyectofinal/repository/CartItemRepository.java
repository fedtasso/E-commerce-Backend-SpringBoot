package com.federicotasso.proyectofinal.repository;

import com.federicotasso.proyectofinal.model.Cart;
import com.federicotasso.proyectofinal.model.CartItem;
import com.federicotasso.proyectofinal.model.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

  Optional<CartItem> findByCartAndProduct(Cart cart, Product product);

  @Query("SELECT ci FROM CartItem ci WHERE ci.cart.id = :cartId AND ci.product.id = :productId")
  Optional<CartItem> findByCartItemAndProductId(@Param("cartId") Long cartId,
      @Param("productId") Long productId);

  void deleteByCartId(Long cartId);
}

