package com.dsi3.api.repository;

import com.dsi3.api.model.entity.Mesa;
import com.dsi3.api.model.entity.Mesa.EstadoMesa;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InterfaceMesaRepository extends JpaRepository<Mesa, Long> {
    List<Mesa> findByEstado(EstadoMesa estado);
    long countByEstado(EstadoMesa estado);
}
