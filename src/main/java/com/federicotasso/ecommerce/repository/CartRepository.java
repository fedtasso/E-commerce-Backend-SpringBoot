package com.federicotasso.ecommerce.repository;

import com.federicotasso.ecommerce.model.Cart;
import com.federicotasso.ecommerce.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart, Long> {

  Optional<Cart> findByUser(User user);

  Optional<Cart> findByUserId(Long userId);

  @Query("SELECT c FROM Cart c JOIN FETCH c.items WHERE c.user.id = :userId")
  Optional<Cart> findByUserIdWithItems(@Param("userId") Long userId);

  boolean existsByUserId(Long userId);
}
