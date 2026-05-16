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
public class UsuarioController implements InterfaceUsuarioController {

    private final InterfaceUsuarioService usuarioService;

    @Override
    public ResponseEntity<UsuarioResponseDTO> crearUsuarios(UsuarioRequestDTO request) {
        return usuarioService.crearUsuarios(request);
    }

    @Override
    public ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @Override
    public ResponseEntity<UsuarioResponseDTO> obtenerUsuario(Long id) {
        return usuarioService.obtenerUsuario(id);
    }

    @Override
    public ResponseEntity<UsuarioResponseDTO> actualizarUsuario(UsuarioRequestDTO request) {
        return usuarioService.actualizarUsuario(request);
    }

    @Override
    public ResponseEntity<String> eliminarUsuario(Long id) {
        return usuarioService.eliminarUsuario(id);
    }

    @Override
    public ResponseEntity<UsuarioResponseDTO> login(UsuarioRequestDTO request) {
        return usuarioService.login(request);
    }
}
