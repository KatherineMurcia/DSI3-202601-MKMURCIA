package com.dsi3.api.model.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoRequestDTO {
    private Long idProducto;
    private Integer cantidad;
}
