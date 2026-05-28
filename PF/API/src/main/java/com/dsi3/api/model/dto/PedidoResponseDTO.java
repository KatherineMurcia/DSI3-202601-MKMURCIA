package com.dsi3.api.model.dto;

import com.dsi3.api.model.entity.Pedido.EstadoPedido;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponseDTO {
    private Long idPedido;
    private Long idMesa;
    private Integer numeroMesa;
    private Long idCliente;
    private String nombreCliente;
    private Long idUsuario;
    private EstadoPedido estado;
    private LocalDateTime fechaCreacion;
    private String observaciones;
    private Double total;
    private List<DetallePedidoResponseDTO> detalles;
}
