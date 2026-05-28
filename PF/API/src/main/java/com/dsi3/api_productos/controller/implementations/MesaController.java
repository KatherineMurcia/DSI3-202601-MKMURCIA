package com.dsi3.api_productos.controller.implementations;

import com.dsi3.api_productos.controller.Interfaces.InterfaceMesaController;
import com.dsi3.api_productos.model.dto.MesaRequestDTO;
import com.dsi3.api_productos.model.dto.MesaResponseDTO;
import com.dsi3.api_productos.service.interfaces.InterfaceMesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MesaController implements InterfaceMesaController {

    private final InterfaceMesaService service;

    public MesaController(InterfaceMesaService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<MesaResponseDTO>> findAll(String estado) {
        return ResponseEntity.ok(service.findAll(estado));
    }

    @Override
    public ResponseEntity<MesaResponseDTO> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<MesaResponseDTO> save(MesaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @Override
    public ResponseEntity<MesaResponseDTO> update(Long id, MesaRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
