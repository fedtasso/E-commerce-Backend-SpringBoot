package com.federicotasso.ecommerce.dto.user;

import com.federicotasso.ecommerce.constants.ValidationConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserCreateRequest {

  @NotBlank(message = "El nombre es obligatorio")
  private String name;

  @NotBlank(message = "El email es obligatorio")
  @Email(message = "El formato del email es inválido")
  private String email;

  @NotBlank(message = "La contraseña es obligatorio")
  @Pattern(regexp = ValidationConstants.PASSWORD_REGEX,
      message = ValidationConstants.PASSWORD_MESSAGE
  )
  private String password;

  private String avatar;

  @Pattern(
      regexp = ValidationConstants.PHONE_REGEX,
      message = "Formato de teléfono inválido"
  )
  private String phone;

}
