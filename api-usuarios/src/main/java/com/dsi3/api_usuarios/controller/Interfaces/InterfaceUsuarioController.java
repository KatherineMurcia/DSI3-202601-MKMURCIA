package com.dsi3.api_usuarios.controller.Interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dsi3.api_usuarios.model.dto.UsuarioRequestDTO;
import com.dsi3.api_usuarios.model.dto.UsuarioResponseDTO;


@RequestMapping("/api/usuarios")
public interface InterfaceUsuarioController {
    @PostMapping()
    ResponseEntity<UsuarioResponseDTO>crearUsuarios(@RequestBody UsuarioRequestDTO request);

    @GetMapping()
    ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios();

    @PutMapping
    ResponseEntity<UsuarioResponseDTO> actualizarUsuario(@RequestBody UsuarioRequestDTO request);

    @DeleteMapping("/{id}")
    ResponseEntity<String> eliminarUsuario(@PathVariable Long id);

    @GetMapping("/{id}")
    ResponseEntity<UsuarioResponseDTO> obtenerUsuario(@PathVariable Long id);

    @PostMapping("/session")
    ResponseEntity<UsuarioResponseDTO> login(@RequestBody UsuarioRequestDTO request);

}
