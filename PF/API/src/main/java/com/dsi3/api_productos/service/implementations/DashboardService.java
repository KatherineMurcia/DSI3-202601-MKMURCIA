package com.dsi3.api_productos.service.implementations;

import com.dsi3.api_productos.model.dto.DashboardResumenDTO;
import com.dsi3.api_productos.repository.InterfaceMesaRepository;
import com.dsi3.api_productos.repository.InterfacePedidoRepository;
import com.dsi3.api_productos.repository.InterfaceProductoRepository;
import com.dsi3.api_productos.service.interfaces.InterfaceDashboardService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DashboardService implements InterfaceDashboardService {

    private final InterfaceProductoRepository productoRepo;
    private final InterfaceMesaRepository     mesaRepo;
    private final InterfacePedidoRepository   pedidoRepo;

    public DashboardService(InterfaceProductoRepository productoRepo,
                            InterfaceMesaRepository mesaRepo,
                            InterfacePedidoRepository pedidoRepo) {
        this.productoRepo = productoRepo;
        this.mesaRepo     = mesaRepo;
        this.pedidoRepo   = pedidoRepo;
    }

    @Override
    public DashboardResumenDTO resumen() {
        long productosActivos    = productoRepo.countByDisponible(true);
        long mesasDisponibles    = mesaRepo.countByEstado("Disponible");
        long pedidosActivos      = pedidoRepo.countByEstadoIn(List.of("Creada", "En preparación"));
        LocalDateTime inicioDia  = LocalDate.now().atStartOfDay();
        LocalDateTime finDia     = inicioDia.plusDays(1);
        long entregadosHoy       = pedidoRepo.countEntregadosEntre(inicioDia, finDia);
        return new DashboardResumenDTO(productosActivos, mesasDisponibles, pedidosActivos, entregadosHoy);
    }
}
