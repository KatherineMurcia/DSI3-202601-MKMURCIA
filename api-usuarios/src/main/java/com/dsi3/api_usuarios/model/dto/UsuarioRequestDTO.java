package com.dsi3.api_usuarios.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class UsuarioRequestDTO {
    private String nombre;
    private String email;
    private String password;
    private int edad;
}
