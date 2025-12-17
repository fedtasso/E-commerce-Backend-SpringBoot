package com.federicotasso.ecommerce.exception.business;

  public class UserNotFoundException extends BusinessException {

  public UserNotFoundException(Long userId) {
    super("Usuario no encontrado con id: " + userId);
  }

  public UserNotFoundException(String email) {
    super("Usuario no encontrado con email: " + email);
  }
}
