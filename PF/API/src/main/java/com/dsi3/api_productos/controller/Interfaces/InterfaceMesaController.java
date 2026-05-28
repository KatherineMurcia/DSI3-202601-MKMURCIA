package com.dsi3.api_productos.controller.Interfaces;

import com.dsi3.api_productos.model.dto.MesaRequestDTO;
import com.dsi3.api_productos.model.dto.MesaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/mesas")
public interface InterfaceMesaController {

    @GetMapping
    ResponseEntity<List<MesaResponseDTO>> findAll(
            @RequestParam(required = false) String estado);

    @GetMapping("/{id}")
    ResponseEntity<MesaResponseDTO> findById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<MesaResponseDTO> save(@RequestBody MesaRequestDTO dto);

    @PutMapping("/{id}")
    ResponseEntity<MesaResponseDTO> update(@PathVariable Long id, @RequestBody MesaRequestDTO dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
