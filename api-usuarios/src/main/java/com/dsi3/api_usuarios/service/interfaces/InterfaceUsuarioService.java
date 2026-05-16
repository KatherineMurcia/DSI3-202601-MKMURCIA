package com.dsi3.api_usuarios.service.interfaces;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.dsi3.api_usuarios.model.dto.UsuarioRequestDTO;
import com.dsi3.api_usuarios.model.dto.UsuarioResponseDTO;

public interface InterfaceUsuarioService {
    ResponseEntity<UsuarioResponseDTO> crearUsuarios(UsuarioRequestDTO request);
    ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios();
    ResponseEntity<UsuarioResponseDTO> obtenerUsuario(Long id);
    ResponseEntity<UsuarioResponseDTO> actualizarUsuario(UsuarioRequestDTO request);
    ResponseEntity<String> eliminarUsuario(Long id);
    ResponseEntity<UsuarioResponseDTO> login(UsuarioRequestDTO request);
}
