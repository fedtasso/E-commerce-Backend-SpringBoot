package com.federicotasso.ecommerce.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserPasswordUpdateRequest {

  @NotBlank(message = "La contraseña actual es obligatoria")
  private String currentPassword;

  @NotBlank(message = "La nueva contraseña es obligatoria")
  @Pattern(
      regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$",
      message = "La nueva contraseña debe tener al menos 6 caracteres, 1 número, 1 mayúscula y 1 minúscula"
  )
  private String newPassword;
}
