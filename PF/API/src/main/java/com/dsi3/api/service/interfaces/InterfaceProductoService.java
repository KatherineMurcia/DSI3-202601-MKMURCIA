package com.dsi3.api.service.interfaces;

import com.dsi3.api.model.dto.ProductoRequestDTO;
import com.dsi3.api.model.dto.ProductoResponseDTO;

import java.util.List;

public interface InterfaceProductoService {

    List<ProductoResponseDTO> findAll(String categoria, Boolean disponible);
    ProductoResponseDTO findById(Long id);
    ProductoResponseDTO save(ProductoRequestDTO dto);
    ProductoResponseDTO update(Long id, ProductoRequestDTO dto);
    void delete(Long id);
}
