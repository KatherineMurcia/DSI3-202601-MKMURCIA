package com.dsi3.api.controller.implementations;

import com.dsi3.api.controller.Interfaces.InterfaceClienteController;
import com.dsi3.api.model.dto.ClienteRequestDTO;
import com.dsi3.api.model.dto.ClienteResponseDTO;
import com.dsi3.api.service.interfaces.InterfaceClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController implements InterfaceClienteController {

    private final InterfaceClienteService service;

    public ClienteController(InterfaceClienteService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<ClienteResponseDTO>> findAll(String busqueda) {
        return ResponseEntity.ok(service.findAll(busqueda));
    }

    @Override
    public ResponseEntity<ClienteResponseDTO> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<ClienteResponseDTO> save(ClienteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @Override
    public ResponseEntity<ClienteResponseDTO> update(Long id, ClienteRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
