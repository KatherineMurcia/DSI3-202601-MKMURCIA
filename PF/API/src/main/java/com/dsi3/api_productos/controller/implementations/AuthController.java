package com.dsi3.api_productos.controller.implementations;

import com.dsi3.api_productos.controller.Interfaces.InterfaceAuthController;
import com.dsi3.api_productos.model.dto.AuthLoginRequestDTO;
import com.dsi3.api_productos.model.dto.AuthRegistroRequestDTO;
import com.dsi3.api_productos.model.dto.AuthResponseDTO;
import com.dsi3.api_productos.service.interfaces.InterfaceAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements InterfaceAuthController {

    private final InterfaceAuthService service;

    public AuthController(InterfaceAuthService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<AuthResponseDTO> registro(AuthRegistroRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registro(dto));
    }

    @Override
    public ResponseEntity<AuthResponseDTO> login(AuthLoginRequestDTO dto) {
        return ResponseEntity.ok(service.login(dto));
    }
}
