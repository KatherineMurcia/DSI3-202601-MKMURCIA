package com.dsi3.api.model.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponseDTO {
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String categoria;
    private String imagenUrl;
    private Boolean disponible;
}
