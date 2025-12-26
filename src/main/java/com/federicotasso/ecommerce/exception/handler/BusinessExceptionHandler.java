package com.federicotasso.ecommerce.exception.handler;

import com.federicotasso.ecommerce.exception.business.ActiveCartNotFoundException;
import com.federicotasso.ecommerce.exception.business.BusinessException;
import com.federicotasso.ecommerce.exception.business.EmailAlreadyExistsException;
import com.federicotasso.ecommerce.exception.business.InvalidCredentialsException;
import com.federicotasso.ecommerce.exception.business.OperationNotAllowedException;
import com.federicotasso.ecommerce.exception.business.ProductNotFoundException;
import com.federicotasso.ecommerce.exception.business.ProductNotInCartException;
import com.federicotasso.ecommerce.exception.business.SamePasswordException;
import com.federicotasso.ecommerce.exception.business.UserNotFoundException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessExceptionHandler {

//  User - Auth
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleUserNotFound(UserNotFoundException ex) {
    return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
  }

  @ExceptionHandler(InvalidCredentialsException.class)
  public ResponseEntity<Map<String, Object>> handleInvalidCredentials(InvalidCredentialsException ex) {
    return buildResponse(HttpStatus.UNAUTHORIZED, ex.getMessage());
  }

  @ExceptionHandler(EmailAlreadyExistsException.class)
  public ResponseEntity<Map<String, Object>> handleEmailAlreadyExists(EmailAlreadyExistsException ex) {
    return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
  }

  @ExceptionHandler(SamePasswordException.class)
  public ResponseEntity<Map<String, Object>> handlePasswordMismatch(SamePasswordException ex) {
    return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
  }

// Authorization
  @ExceptionHandler(OperationNotAllowedException.class)
  public ResponseEntity<Map<String, Object>> handleOperationNotAllowed(OperationNotAllowedException ex) {
    return buildResponse(HttpStatus.FORBIDDEN, ex.getMessage());
  }

//  Product
  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleProductNotFound(ProductNotFoundException ex) {
    return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
  }

//  Cart
  @ExceptionHandler(ActiveCartNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleActiveCartNotFound(ActiveCartNotFoundException ex) {
    return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
  }

  @ExceptionHandler(ProductNotInCartException.class)
  public ResponseEntity<Map<String, Object>> handleProductNotInCart(ProductNotInCartException ex) {
    return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
  }


  // Para excepciones de negocio no mapeadas explícitamente
  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<Map<String, Object>> handleGenericBusinessException(BusinessException ex) {
    return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
  }

  private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message) {
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("status", status.value());
    body.put("error", status.getReasonPhrase());
    body.put("message", message);
    return ResponseEntity.status(status).body(body);
  }
}


// TODO Evolucionar luego a respuesta RFC 9457:
//{
//    "type": "api.tusitio.com",
//    "title": "Not Found",
//    "status": 404,
//    "detail": "Producto no encontrado",
//    "instance": "/api/products/10",
//    "timestamp": "2025-01-01T12:00:00Z"
//    }