package com.dsi3.api_productos.repository;

import com.dsi3.api_productos.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface InterfacePedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByEstado(String estado);

    boolean existsByMesa_IdMesaAndEstadoIn(Long idMesa, List<String> estados);

    long countByEstadoIn(List<String> estados);

    @Query("SELECT COUNT(p) FROM Pedido p WHERE p.estado = 'Entregada' AND p.fechaCreacion >= :inicio AND p.fechaCreacion < :fin")
    long countEntregadosEntre(@Param("inicio") LocalDateTime inicio, @Param("fin") LocalDateTime fin);
}
