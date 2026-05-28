package com.dsi3.api_productos.controller.Interfaces;

import com.dsi3.api_productos.model.dto.AuthLoginRequestDTO;
import com.dsi3.api_productos.model.dto.AuthRegistroRequestDTO;
import com.dsi3.api_productos.model.dto.AuthResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
public interface InterfaceAuthController {

    @PostMapping("/registro")
    ResponseEntity<AuthResponseDTO> registro(@RequestBody AuthRegistroRequestDTO dto);

    @PostMapping("/login")
    ResponseEntity<AuthResponseDTO> login(@RequestBody AuthLoginRequestDTO dto);
}
