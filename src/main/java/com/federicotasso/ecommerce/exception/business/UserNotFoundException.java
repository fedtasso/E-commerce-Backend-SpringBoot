package com.federicotasso.ecommerce.exception.business;

  public class UserNotFoundException extends BusinessException {

  public UserNotFoundException(Long userId) {
    super("El usuario id numero %s no fue encontrado".formatted(userId));
  }

  public UserNotFoundException(String email) {
    super("El email %s no fue encontrado".formatted(email));
  }
}
