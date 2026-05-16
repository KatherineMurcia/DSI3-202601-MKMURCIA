package com.dsi3.api_usuarios.service.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dsi3.api_usuarios.mapper.UsuarioMapper;
import com.dsi3.api_usuarios.model.dto.UsuarioRequestDTO;
import com.dsi3.api_usuarios.model.dto.UsuarioResponseDTO;
import com.dsi3.api_usuarios.model.entity.Usuario;
import com.dsi3.api_usuarios.repository.InterfaceUsuarioRepository;
import com.dsi3.api_usuarios.service.interfaces.InterfaceUsuarioService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioService implements InterfaceUsuarioService {

    private final InterfaceUsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public ResponseEntity<UsuarioResponseDTO> crearUsuarios(UsuarioRequestDTO request) {
        Usuario usuario = this.usuarioMapper.usuarioRequestToUsuario(request);
        Usuario newUser = usuarioRepository.save(usuario);
        UsuarioResponseDTO responserUser = this.usuarioMapper.usarioToUsuarioResponseDTO(newUser);
        return ResponseEntity.status(201).body(responserUser);
    }

    @Override
    public ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios() {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        List<UsuarioResponseDTO> responseUsuario = new ArrayList<>();
        for (int i = 0; i < usuarioList.size(); i++) {
            UsuarioResponseDTO responseUser = usuarioMapper.usarioToUsuarioResponseDTO(usuarioList.get(i));
            responseUsuario.add(responseUser);
        }
        if (responseUsuario.size() > 0) {
            return ResponseEntity.ok(responseUsuario);
        }
        return ResponseEntity.status(404).body(null);
    }

    @Override
    public ResponseEntity<UsuarioResponseDTO> obtenerUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuarioMapper.usarioToUsuarioResponseDTO(usuario.get()));
        }
        return ResponseEntity.status(404).body(null);
    }

    @Override
    public ResponseEntity<UsuarioResponseDTO> actualizarUsuario(UsuarioRequestDTO request) {
        return ResponseEntity.status(501).body(null);
    }

    @Override
    public ResponseEntity<String> eliminarUsuario(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        }
        return ResponseEntity.status(404).body("Usuario no encontrado");
    }

    @Override
    public ResponseEntity<UsuarioResponseDTO> login(UsuarioRequestDTO request) {
        return ResponseEntity.status(501).body(null);
    }
}
