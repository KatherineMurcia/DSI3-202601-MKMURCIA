package com.dsi3.api.controller.implementations;

import com.dsi3.api.controller.Interfaces.InterfaceDashboardController;
import com.dsi3.api.model.dto.DashboardResumenDTO;
import com.dsi3.api.service.interfaces.InterfaceDashboardService;
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
