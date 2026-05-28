package com.dsi3.api.mapper;

import com.dsi3.api.model.dto.ProductoRequestDTO;
import com.dsi3.api.model.dto.ProductoResponseDTO;
import com.dsi3.api.model.entity.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public Producto toEntity(ProductoRequestDTO dto) {
        return Producto.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .precio(dto.getPrecio())
                .categoria(dto.getCategoria())
                .imagenUrl(dto.getImagenUrl())
                .disponible(dto.getDisponible())
                .build();
    }

    public ProductoResponseDTO toDTO(Producto entity) {
        return ProductoResponseDTO.builder()
                .idProducto(entity.getIdProducto())
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .precio(entity.getPrecio())
                .categoria(entity.getCategoria())
                .imagenUrl(entity.getImagenUrl())
                .disponible(entity.getDisponible())
                .build();
    }
}
