package com.dsi3.api.controller.Interfaces;

import com.dsi3.api.model.dto.ClienteRequestDTO;
import com.dsi3.api.model.dto.ClienteResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/clientes")
public interface InterfaceClienteController {

    @GetMapping
    ResponseEntity<List<ClienteResponseDTO>> findAll(
            @RequestParam(required = false) String busqueda);

    @GetMapping("/{id}")
    ResponseEntity<ClienteResponseDTO> findById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<ClienteResponseDTO> save(@RequestBody ClienteRequestDTO dto);

    @PutMapping("/{id}")
    ResponseEntity<ClienteResponseDTO> update(@PathVariable Long id, @RequestBody ClienteRequestDTO dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
