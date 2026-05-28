package com.dsi3.api.model.dto;

import lombok.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequestDTO {
    private Long idMesa;
    private Long idCliente;
    private Long idUsuario;
    private String observaciones;
    private List<DetallePedidoRequestDTO> detalles;
}
