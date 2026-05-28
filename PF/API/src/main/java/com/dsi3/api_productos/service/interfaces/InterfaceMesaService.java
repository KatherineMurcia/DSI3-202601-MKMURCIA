package com.dsi3.api_productos.service.interfaces;

import com.dsi3.api_productos.model.dto.MesaRequestDTO;
import com.dsi3.api_productos.model.dto.MesaResponseDTO;

import java.util.List;

public interface InterfaceMesaService {

    List<MesaResponseDTO> findAll(String estado);
    MesaResponseDTO findById(Long id);
    MesaResponseDTO save(MesaRequestDTO dto);
    MesaResponseDTO update(Long id, MesaRequestDTO dto);
    void delete(Long id);
}
