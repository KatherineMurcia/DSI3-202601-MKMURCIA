package com.dsi3.api.controller.Interfaces;

import com.dsi3.api.model.dto.DetallePedidoRequestDTO;
import com.dsi3.api.model.dto.DetallePedidoResponseDTO;
import com.dsi3.api.model.dto.PedidoRequestDTO;
import com.dsi3.api.model.dto.PedidoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pedidos")
public interface InterfacePedidoController {

    @GetMapping
    ResponseEntity<List<PedidoResponseDTO>> findAll(
            @RequestParam(required = false) String estado);

    @GetMapping("/{id}")
    ResponseEntity<PedidoResponseDTO> findById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<PedidoResponseDTO> save(@RequestBody PedidoRequestDTO dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @PatchMapping("/{id}/estado")
    ResponseEntity<PedidoResponseDTO> avanzarEstado(@PathVariable Long id);

    @PostMapping("/{id}/detalles")
    ResponseEntity<DetallePedidoResponseDTO> agregarDetalle(
            @PathVariable Long id,
            @RequestBody DetallePedidoRequestDTO dto);

    @DeleteMapping("/{id}/detalles/{detalleId}")
    ResponseEntity<Void> eliminarDetalle(
            @PathVariable Long id,
            @PathVariable Long detalleId);
}
