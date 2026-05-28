package com.dsi3.api.service.interfaces;

import com.dsi3.api.model.dto.DetallePedidoRequestDTO;
import com.dsi3.api.model.dto.DetallePedidoResponseDTO;
import com.dsi3.api.model.dto.PedidoRequestDTO;
import com.dsi3.api.model.dto.PedidoResponseDTO;

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
