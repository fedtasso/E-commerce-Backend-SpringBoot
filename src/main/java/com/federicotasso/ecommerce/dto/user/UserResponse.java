package com.federicotasso.ecommerce.dto.user;

import com.federicotasso.ecommerce.model.UserRole;
import java.time.LocalDateTime;
import lombok.Data;


@Data
public class UserResponse {

  private Long id;
  private String name;
  private String email;
  private UserRole role;
  private String avatar;
  private Boolean active;
  private LocalDateTime lastLogin;
  private String phone;
  private LocalDateTime createdAt;
}
