package com.federicotasso.ecommerce.exception.business;

public class ActiveCartNotFoundException extends BusinessException{

     public ActiveCartNotFoundException(Long userId) {
      super("Carrito no encontrado para el usuario %s".formatted(userId));
    }

}
