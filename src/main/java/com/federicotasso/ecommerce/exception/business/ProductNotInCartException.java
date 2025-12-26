package com.federicotasso.ecommerce.exception.business;

public class ProductNotInCartException extends BusinessException {

  public ProductNotInCartException(Long userId) {
    super("El producto id numero %s no está en el carrito".formatted(userId));
  }

}
