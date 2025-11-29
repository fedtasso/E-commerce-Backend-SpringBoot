package com.federicotasso.ecommerce.dto.user;

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
  @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$",
      message = "La contraseña debe tener al menos 6 caracteres, 1 número, 1 mayúscula y 1 minúscula"
  )
  private String password;

  private String avatar;

  @Pattern(
      regexp = "^[+]?[(]?\\d{1,4}[)]?[-.\\s]*\\d{1,4}[-.\\s]*\\d{1,4}[-.\\s]*\\d{1,9}$",
      message = "Formato de teléfono inválido"
  )
  private String phone;

}
