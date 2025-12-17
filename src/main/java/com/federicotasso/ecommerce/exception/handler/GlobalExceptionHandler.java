package com.federicotasso.ecommerce.exception.handler;

import jakarta.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  // 1. DTO validation errors (body validation)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {

    Map<String, String> fieldErrors = new HashMap<>();

    ex.getBindingResult().getFieldErrors()
        .forEach(error -> fieldErrors.put(error.getField(), error.getDefaultMessage()));

    return buildResponse(
        HttpStatus.BAD_REQUEST,
        "Error de validación",
        fieldErrors
    );
  }

  // 2. Validation of path/query parameters (@Valid in params)
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<Map<String, Object>> handleConstraintViolation(ConstraintViolationException ex) {

    Map<String, String> errors = new HashMap<>();
    ex.getConstraintViolations()
        .forEach(v -> errors.put(v.getPropertyPath().toString(), v.getMessage()));

    return buildResponse(
        HttpStatus.BAD_REQUEST,
        "Parámetros inválidos",
        errors
    );
  }


  //3. Malformed JSON or incorrect data types in request body
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<Map<String, Object>> handleUnreadableMessage(HttpMessageNotReadableException ex) {
    return buildResponse(
        HttpStatus.BAD_REQUEST,
        "JSON mal formado o tipo de dato incorrecto"
    );
  }

  // 4. Type mismatch in URL parameters (e.g., id=abc for Long)
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<Map<String, Object>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {

    String detail = "El parámetro '" + ex.getName() + "' con valor '" + ex.getValue()
        + "' no puede convertirse al tipo " + ex.getRequiredType().getSimpleName();

    return buildResponse(HttpStatus.BAD_REQUEST, detail);
  }

  // 5. HTTP method not supported
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<Map<String, Object>> handleMethodNotSupported(
      HttpRequestMethodNotSupportedException ex) {

    String message = "Método HTTP no permitido para este endpoint";

    Map<String, Object> details = Map.of(
        "method", ex.getMethod(),
        "supportedMethods", ex.getSupportedHttpMethods()
    );

    return buildResponse(
        HttpStatus.METHOD_NOT_ALLOWED,
        message,
        details
    );
  }

  // 6. Missing required request parameter
  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ResponseEntity<Map<String, Object>> handleMissingRequestParam(
      MissingServletRequestParameterException ex) {

    String message = "Falta un parámetro requerido";

    Map<String, Object> details = Map.of(
        "parameter", ex.getParameterName(),
        "expectedType", ex.getParameterType()
    );

    return buildResponse(
        HttpStatus.BAD_REQUEST,
        message,
        details
    );
  }

  // 7. Endpoint not found (404)
  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<Map<String, Object>> handleNoHandlerFound(
      NoHandlerFoundException ex) {

    String message = "Endpoint no encontrado";

    Map<String, Object> details = Map.of(
        "path", ex.getRequestURL(),
        "method", ex.getHttpMethod()
    );

    return buildResponse(
        HttpStatus.NOT_FOUND,
        message,
        details
    );
  }

  // 6. Fallback for unexpected exceptions
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {

    return buildResponse(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "Error interno del servidor",
        Map.of("detalle", ex.getMessage())
    );
  }


  // Utility methods to standardize the JSON response format
  private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message) {

    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("status", status.value());
    body.put("error", status.getReasonPhrase());
    body.put("message", message);

    return ResponseEntity.status(status).body(body);
  }

  private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status, String message, Object details) {

    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("status", status.value());
    body.put("error", status.getReasonPhrase());
    body.put("message", message);
    body.put("details", details);

    return ResponseEntity.status(status).body(body);
  }
}
