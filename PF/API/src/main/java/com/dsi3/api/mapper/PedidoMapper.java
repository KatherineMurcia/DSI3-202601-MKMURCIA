package com.dsi3.api.mapper;

import com.dsi3.api.model.dto.DetallePedidoResponseDTO;
import com.dsi3.api.model.dto.PedidoResponseDTO;
import com.dsi3.api.model.entity.DetallePedido;
import com.dsi3.api.model.entity.Pedido;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoMapper {

    private final MesaMapper     mesaMapper;
    private final ClienteMapper  clienteMapper;
    private final ProductoMapper productoMapper;

    public PedidoMapper(MesaMapper mesaMapper, ClienteMapper clienteMapper, ProductoMapper productoMapper) {
        this.mesaMapper     = mesaMapper;
        this.clienteMapper  = clienteMapper;
        this.productoMapper = productoMapper;
    }

    public DetallePedidoResponseDTO toDetalleDTO(DetallePedido d) {
        return new DetallePedidoResponseDTO(
                d.getIdDetalle(),
                productoMapper.toResponseDTO(d.getProducto()),
                d.getCantidad(),
                d.getPrecioUnitario(),
                d.getSubtotal()
        );
    }

    public PedidoResponseDTO toResponseDTO(Pedido p) {
        List<DetallePedidoResponseDTO> detalles = p.getDetalles() == null
                ? new ArrayList<>()
                : p.getDetalles().stream().map(this::toDetalleDTO).collect(Collectors.toList());

        return new PedidoResponseDTO(
                p.getIdPedido(),
                p.getMesa()    != null ? mesaMapper.toResponseDTO(p.getMesa())       : null,
                p.getCliente() != null ? clienteMapper.toResponseDTO(p.getCliente()) : null,
                p.getFechaCreacion(),
                p.getEstado(),
                p.getObservaciones(),
                detalles,
                p.getTotal()
        );
    }
}
