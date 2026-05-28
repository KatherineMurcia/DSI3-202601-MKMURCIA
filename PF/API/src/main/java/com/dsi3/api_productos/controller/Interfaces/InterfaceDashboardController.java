package com.dsi3.api_productos.controller.Interfaces;

import com.dsi3.api_productos.model.dto.DashboardResumenDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/dashboard")
public interface InterfaceDashboardController {

    @GetMapping("/resumen")
    ResponseEntity<DashboardResumenDTO> resumen();
}
