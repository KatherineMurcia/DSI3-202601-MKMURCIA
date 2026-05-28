package com.dsi3.api.mapper;

import com.dsi3.api.model.dto.DetallePedidoResponseDTO;
import com.dsi3.api.model.entity.DetallePedido;
import org.springframework.stereotype.Component;

@Component
public class DetallePedidoMapper {

    public DetallePedidoResponseDTO toDTO(DetallePedido entity) {
        return DetallePedidoResponseDTO.builder()
                .idDetalle(entity.getIdDetalle())
                .idProducto(entity.getProducto().getIdProducto())
                .nombreProducto(entity.getProducto().getNombre())
                .cantidad(entity.getCantidad())
                .precioUnitario(entity.getPrecioUnitario())
                .subtotal(entity.getSubtotal())
                .build();
    }
}
