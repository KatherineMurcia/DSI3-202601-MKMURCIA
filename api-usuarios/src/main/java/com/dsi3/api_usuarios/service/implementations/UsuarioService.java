package com.dsi3.api_usuarios.service.implementations;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dsi3.api_usuarios.mapper.UsuarioMapper;
import com.dsi3.api_usuarios.model.dto.UsuarioRequestDTO;
import com.dsi3.api_usuarios.model.dto.UsuarioResponseDTO;
import com.dsi3.api_usuarios.model.entity.Usuario;
import com.dsi3.api_usuarios.repository.InterfaceUsuarioRepository;
import com.dsi3.api_usuarios.service.interfaces.InterfaceUsuarioService;
 @Service
public class UsuarioService implements InterfaceUsuarioService{

    private final InterfaceUsuarioRepository usuarioRepository = null;
    private final UsuarioMapper usuarioMapper = new UsuarioMapper();

    @Override
    public ResponseEntity<UsuarioResponseDTO> crearUsuarios(UsuarioRequestDTO request) {
        //Convertir el requestDTO en entity
        Usuario usuario = this.usuarioMapper.usuarioRequestToUsuario(request);
        //Operacion con BDD
        Usuario newUser= usuarioRepository.save(usuario);
        //Convertir entity en requestDTO
        UsuarioResponseDTO responserUser = this.usuarioMapper.usarioToUsuarioResponseDTO(newUser);
        return ResponseEntity.status(201).body(responserUser);
    }

    @Override
    public ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios() {
        List<Usuario> usuarioList= usuarioRepository.findAll();
        List<UsuarioResponseDTO> responseUsuario = new ArrayList<>();

        for (int i =0;i<usuarioList.size();i++) {
            UsuarioResponseDTO responseUser = usuarioMapper.usarioToUsuarioResponseDTO(usuarioList.get(i));
            responseUsuario.add(responseUser);
        }
        if (responseUsuario.size()>0) {
            return ResponseEntity.ok(responseUsuario);
        }
        return ResponseEntity.status(404).body(null);
        }

}
