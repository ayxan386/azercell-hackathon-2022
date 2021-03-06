package com.fayda.command.dto.register;

import com.fayda.command.constants.UserTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponseDTO {
  private String token;
  private UserTypes type;
}
