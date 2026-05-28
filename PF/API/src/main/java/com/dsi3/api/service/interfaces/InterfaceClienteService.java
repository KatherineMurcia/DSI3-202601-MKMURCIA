package com.dsi3.api.service.interfaces;

import com.dsi3.api.model.dto.ClienteRequestDTO;
import com.dsi3.api.model.dto.ClienteResponseDTO;

import java.util.List;

public interface InterfaceClienteService {

    List<ClienteResponseDTO> findAll(String busqueda);
    ClienteResponseDTO findById(Long id);
    ClienteResponseDTO save(ClienteRequestDTO dto);
    ClienteResponseDTO update(Long id, ClienteRequestDTO dto);
    void delete(Long id);
}
