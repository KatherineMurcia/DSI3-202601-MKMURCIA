package com.dsi3.api.model.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponseDTO {
    private Long idCliente;
    private String nombre;
    private String telefono;
    private String email;
    private LocalDateTime fechaRegistro;
}
