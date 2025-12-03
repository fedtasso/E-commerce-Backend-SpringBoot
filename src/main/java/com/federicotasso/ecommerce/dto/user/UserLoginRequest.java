package com.federicotasso.ecommerce.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserLoginRequest {

  @NotBlank(message = "El email es obligatorio")
  private String email;

  @NotBlank(message = "La contraseña es obligatoria")
  @Pattern(
      regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$",
      message = "La nueva debe tener al menos 6 caracteres, 1 número, 1 mayúscula y 1 minúscula"
  )
  private String password;
}
