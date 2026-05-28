package com.dsi3.api.repository;

import com.dsi3.api.model.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceDetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}
