package com.dsi3.api_productos.controller.implementations;

import com.dsi3.api_productos.controller.Interfaces.InterfaceDashboardController;
import com.dsi3.api_productos.model.dto.DashboardResumenDTO;
import com.dsi3.api_productos.service.interfaces.InterfaceDashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController implements InterfaceDashboardController {

    private final InterfaceDashboardService service;

    public DashboardController(InterfaceDashboardService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<DashboardResumenDTO> resumen() {
        return ResponseEntity.ok(service.resumen());
    }
}
