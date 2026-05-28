package com.dsi3.api_productos.service.interfaces;

import com.dsi3.api_productos.model.dto.ProductoRequestDTO;
import com.dsi3.api_productos.model.dto.ProductoResponseDTO;

import java.util.List;

public interface InterfaceProductoService {

    List<ProductoResponseDTO> findAll(String categoria, Boolean disponible);
    ProductoResponseDTO findById(Long id);
    ProductoResponseDTO save(ProductoRequestDTO dto);
    ProductoResponseDTO update(Long id, ProductoRequestDTO dto);
    void delete(Long id);
}
