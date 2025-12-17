package com.federicotasso.ecommerce.dto.user;

import com.federicotasso.ecommerce.constants.ValidationConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserLoginRequest {

  @NotBlank(message = "El email es obligatorio")
  @Email
  private String email;

  @NotBlank(message = "La contraseña es obligatoria")
  @Pattern(
      regexp = ValidationConstants.PASSWORD_REGEX,
      message = ValidationConstants.PASSWORD_MESSAGE
  )
  private String password;
}
