package com.dsi3.api_usuarios.controller.implementations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dsi3.api_usuarios.controller.Interfaces.InterfaceUsuarioController;
import com.dsi3.api_usuarios.model.dto.UsuarioRequestDTO;
import com.dsi3.api_usuarios.model.dto.UsuarioResponseDTO;
import com.dsi3.api_usuarios.service.interfaces.InterfaceUsuarioService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UsuarioController implements InterfaceUsuarioController{
    
    private final InterfaceUsuarioService usuarioService;

    @Override
    public ResponseEntity<UsuarioResponseDTO> crearUsuarios(UsuarioRequestDTO request) {
        return usuarioService.crearUsuarios(request);
    }

    @Override
    public ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();

    }

}
