package com.federicotasso.ecommerce.exception.business;

public class OperationNotAllowedException extends BusinessException {

  public OperationNotAllowedException(String reason) {
    super(reason);
  }
}

