package com.federicotasso.ecommerce.dto.user;

import com.federicotasso.ecommerce.constants.ValidationConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserPasswordUpdateRequest {

  @NotBlank(message = "La contraseña actual es obligatoria")
  private String currentPassword;

  @NotBlank(message = "La nueva contraseña es obligatoria")
  @Pattern(
      regexp = ValidationConstants.PASSWORD_REGEX,
      message = ValidationConstants.PASSWORD_MESSAGE
  )
  private String newPassword;
}
