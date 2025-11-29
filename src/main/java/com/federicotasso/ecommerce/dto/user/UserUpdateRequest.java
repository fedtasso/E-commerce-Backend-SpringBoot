package com.federicotasso.ecommerce.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserUpdateRequest {


  private String name;

  @Email(message = "El formato del email es inválido")
  private String email;

  private String avatar;

  @Pattern(
      regexp = "^[+]?[(]?\\d{1,4}[)]?[-.\\s]*\\d{1,4}[-.\\s]*\\d{1,4}[-.\\s]*\\d{1,9}$",
      message = "Formato de teléfono inválido"
  )
  private String phone;

}
