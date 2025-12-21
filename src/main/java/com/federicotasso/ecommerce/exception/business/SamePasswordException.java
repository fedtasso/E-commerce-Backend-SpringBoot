package com.federicotasso.ecommerce.exception.business;

public class SamePasswordException extends BusinessException {

  public SamePasswordException() {
    super("La nueva contraseña es igual a la actual");
  }

}
