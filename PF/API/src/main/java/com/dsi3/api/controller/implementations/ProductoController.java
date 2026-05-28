package com.dsi3.api.controller.implementations;

import com.dsi3.api.controller.Interfaces.InterfaceProductoController;
import com.dsi3.api.model.dto.ProductoRequestDTO;
import com.dsi3.api.model.dto.ProductoResponseDTO;
import com.dsi3.api.service.interfaces.InterfaceProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController implements InterfaceProductoController {

    private final InterfaceProductoService service;

    public ProductoController(InterfaceProductoService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<ProductoResponseDTO>> findAll(String categoria, Boolean disponible) {
        return ResponseEntity.ok(service.findAll(categoria, disponible));
    }

    @Override
    public ResponseEntity<ProductoResponseDTO> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<ProductoResponseDTO> save(ProductoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @Override
    public ResponseEntity<ProductoResponseDTO> update(Long id, ProductoRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
