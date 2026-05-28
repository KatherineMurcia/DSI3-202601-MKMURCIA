package com.dsi3.api_productos.repository;

import com.dsi3.api_productos.model.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceDetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}
