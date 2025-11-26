package com.federicotasso.proyectofinal.mapper;

import com.federicotasso.proyectofinal.dto.UserCreateRequest;
import com.federicotasso.proyectofinal.dto.UserResponse;
import com.federicotasso.proyectofinal.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User toEntity(UserCreateRequest request) {
    User user = new User();
    user.setName(request.getName());
    user.setEmail(request.getEmail());
    user.setAvatar(request.getAvatar());
    user.setPhone(request.getPhone());
    return user;
  }

  public UserResponse toResponse(User user) {
    UserResponse userResponse = new UserResponse();
    userResponse.setId(user.getId());
    userResponse.setName(user.getName());
    userResponse.setEmail(user.getEmail());
    userResponse.setActive(user.getActive());
    userResponse.setAvatar(user.getAvatar());
    userResponse.setPhone(user.getPhone());
    userResponse.setRole(user.getRole());
    userResponse.setCreatedAt(user.getCreatedAt());
    userResponse.setLastLogin(user.getLastLogin());
    return userResponse;
  }
}
