package com.federicotasso.ecommerce.exception.business;

public class ProductNotFoundException extends BusinessException {

  public ProductNotFoundException(Long productId) {
    super("El producto id numero %s no fue encontrado".formatted(productId));
  }

}