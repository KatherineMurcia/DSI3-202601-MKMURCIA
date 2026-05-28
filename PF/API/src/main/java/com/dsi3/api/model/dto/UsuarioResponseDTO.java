package com.dsi3.api.model.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResponseDTO {
    private Long idUsuario;
    private String nombre;
    private String email;
    private Boolean activo;
}
