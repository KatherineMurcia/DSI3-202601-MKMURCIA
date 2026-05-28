package com.dsi3.api_productos.repository;

import com.dsi3.api_productos.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterfaceProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByCategoria(String categoria);
    List<Producto> findByDisponible(Boolean disponible);
    List<Producto> findByCategoriaAndDisponible(String categoria, Boolean disponible);
    long countByDisponible(Boolean disponible);
}
