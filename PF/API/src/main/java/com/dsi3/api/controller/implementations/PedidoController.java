package com.dsi3.api.controller.implementations;

import com.dsi3.api.controller.Interfaces.InterfacePedidoController;
import com.dsi3.api.model.dto.DetallePedidoRequestDTO;
import com.dsi3.api.model.dto.DetallePedidoResponseDTO;
import com.dsi3.api.model.dto.PedidoRequestDTO;
import com.dsi3.api.model.dto.PedidoResponseDTO;
import com.dsi3.api.service.interfaces.InterfacePedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PedidoController implements InterfacePedidoController {

    private final InterfacePedidoService service;

    public PedidoController(InterfacePedidoService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<PedidoResponseDTO>> findAll(String estado) {
        return ResponseEntity.ok(service.findAll(estado));
    }

    @Override
    public ResponseEntity<PedidoResponseDTO> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<PedidoResponseDTO> save(PedidoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<PedidoResponseDTO> avanzarEstado(Long id) {
        return ResponseEntity.ok(service.avanzarEstado(id));
    }

    @Override
    public ResponseEntity<DetallePedidoResponseDTO> agregarDetalle(Long id, DetallePedidoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.agregarDetalle(id, dto));
    }

    @Override
    public ResponseEntity<Void> eliminarDetalle(Long id, Long detalleId) {
        service.eliminarDetalle(id, detalleId);
        return ResponseEntity.noContent().build();
    }
}
