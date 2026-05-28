package com.dsi3.api_productos.repository;

import com.dsi3.api_productos.model.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterfaceMesaRepository extends JpaRepository<Mesa, Long> {

    List<Mesa> findByEstado(String estado);
    long countByEstado(String estado);
}
