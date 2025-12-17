package com.federicotasso.ecommerce.exception.business;

public abstract class BusinessException extends RuntimeException {

  protected BusinessException(String message) {
    super(message);
  }
}