package com.federicotasso.ecommerce.exception.business;

public class EmailAlreadyExistsException extends BusinessException {

  public EmailAlreadyExistsException(String email) {
    super("El email ya se encuentra registrado: " + email);
  }
}
