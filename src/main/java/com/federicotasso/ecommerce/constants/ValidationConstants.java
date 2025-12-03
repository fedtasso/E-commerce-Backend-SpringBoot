package com.federicotasso.ecommerce.constants;

public class ValidationConstants  {

  private ValidationConstants() {

  }


  public static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[A-Z]).{8,}$";
  public static final String PASSWORD_MESSAGE =
      "La contraseña debe tener mínimo 8 caracteres, al menos un número y una letra mayúscula";

  public static final String PHONE_REGEX = "^[+]?[0-9\\s]{10,15}$";

}
