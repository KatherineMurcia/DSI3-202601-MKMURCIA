package com.dsi3.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRequestDTO {
    private String nombre;
    private String descripcion;
    private Double precio;
    private String categoria;
    private String imagenUrl;
    private Boolean disponible;
}
