package com.dsi3.api.model.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {
    private String nombre;
    private String email;
    private String password;
}
