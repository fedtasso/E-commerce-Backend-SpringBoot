package com.federicotasso.ecommerce.exception.business;

public class InvalidCredentialsException extends BusinessException {

  public InvalidCredentialsException() {
    super("Credenciales inválidas");
  }
}
