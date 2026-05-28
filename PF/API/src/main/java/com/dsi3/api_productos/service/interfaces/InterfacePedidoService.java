package com.dsi3.api_productos.service.interfaces;

import com.dsi3.api_productos.model.dto.DetallePedidoRequestDTO;
import com.dsi3.api_productos.model.dto.DetallePedidoResponseDTO;
import com.dsi3.api_productos.model.dto.PedidoRequestDTO;
import com.dsi3.api_productos.model.dto.PedidoResponseDTO;

import java.util.List;

public interface InterfacePedidoService {

    List<PedidoResponseDTO> findAll(String estado);
    PedidoResponseDTO findById(Long id);
    PedidoResponseDTO save(PedidoRequestDTO dto);
    void delete(Long id);
    PedidoResponseDTO avanzarEstado(Long id);
    DetallePedidoResponseDTO agregarDetalle(Long idPedido, DetallePedidoRequestDTO dto);
    void eliminarDetalle(Long idPedido, Long idDetalle);
}
