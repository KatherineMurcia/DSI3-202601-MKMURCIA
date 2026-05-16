package com.dsi3.api_usuarios.mapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.dsi3.api_usuarios.model.dto.UsuarioRequestDTO;
import com.dsi3.api_usuarios.model.dto.UsuarioResponseDTO;
import com.dsi3.api_usuarios.model.entity.Usuario;
@Component
public class UsuarioMapper {
    public Usuario usuarioRequestToUsuario(UsuarioRequestDTO dto){
       return Usuario.builder()
       .name(dto.getNombre())
       .email(dto.getEmail())
       .password(dto.getPassword())
       .edad(dto.getEdad())
       .build();

    }
    public UsuarioResponseDTO usarioToUsuarioResponseDTO(Usuario model){
       return UsuarioResponseDTO.builder()
       .id(model.getId())
       .nombre(model.getName())
       .email(model.getEmail())
       .edad(model.getEdad())
       .build();

    }
}
