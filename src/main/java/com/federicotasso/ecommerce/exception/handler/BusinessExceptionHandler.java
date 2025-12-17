package com.federicotasso.ecommerce.exception.handler;

import com.federicotasso.ecommerce.exception.business.BusinessException;
import com.federicotasso.ecommerce.exception.business.EmailAlreadyExistsException;
import com.federicotasso.ecommerce.exception.business.InvalidCredentialsException;
import com.federicotasso.ecommerce.exception.business.OperationNotAllowedException;
import com.federicotasso.ecommerce.exception.business.UserNotFoundException;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessExceptionHandler {

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

  @ExceptionHandler(OperationNotAllowedException.class)
  public ResponseEntity<Map<String, Object>> handleOperationNotAllowed(OperationNotAllowedException ex) {
    return buildResponse(HttpStatus.FORBIDDEN, ex.getMessage());
  }

  // Para excepciones de negocio no mapeadas explícitamente
  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<Map<String, Object>> handleGenericBusinessException(BusinessException ex) {
    return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
  }

  private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message) {
    return ResponseEntity
        .status(status)
        .body(Map.of(
            "status", status.value(),
            "error", message
        ));
  }
}
