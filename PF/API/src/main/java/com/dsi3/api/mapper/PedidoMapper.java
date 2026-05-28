package com.dsi3.api.mapper;

import com.dsi3.api.model.dto.PedidoResponseDTO;
import com.dsi3.api.model.entity.Pedido;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PedidoMapper {

    private final DetallePedidoMapper detallePedidoMapper;

    public PedidoResponseDTO toDTO(Pedido entity) {
        return PedidoResponseDTO.builder()
                .idPedido(entity.getIdPedido())
                .idMesa(entity.getMesa().getIdMesa())
                .numeroMesa(entity.getMesa().getNumero())
                .idCliente(entity.getCliente() != null ? entity.getCliente().getIdCliente() : null)
                .nombreCliente(entity.getCliente() != null ? entity.getCliente().getNombre() : null)
                .idUsuario(entity.getUsuario().getIdUsuario())
                .estado(entity.getEstado())
                .fechaCreacion(entity.getFechaCreacion())
                .observaciones(entity.getObservaciones())
                .total(entity.getDetalles().stream()
                        .mapToDouble(d -> d.getSubtotal())
                        .sum())
                .detalles(entity.getDetalles().stream()
                        .map(detallePedidoMapper::toDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}
