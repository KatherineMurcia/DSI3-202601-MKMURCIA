package com.dsi3.api_productos.controller.Interfaces;

import com.dsi3.api_productos.model.dto.ProductoRequestDTO;
import com.dsi3.api_productos.model.dto.ProductoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/productos")
public interface InterfaceProductoController {

    @GetMapping
    ResponseEntity<List<ProductoResponseDTO>> findAll(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) Boolean disponible);

    @GetMapping("/{id}")
    ResponseEntity<ProductoResponseDTO> findById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<ProductoResponseDTO> save(@RequestBody ProductoRequestDTO dto);

    @PutMapping("/{id}")
    ResponseEntity<ProductoResponseDTO> update(@PathVariable Long id, @RequestBody ProductoRequestDTO dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
