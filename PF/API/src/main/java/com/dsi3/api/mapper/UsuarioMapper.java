package com.dsi3.api.mapper;

import com.dsi3.api.model.dto.UsuarioRequestDTO;
import com.dsi3.api.model.dto.UsuarioResponseDTO;
import com.dsi3.api.model.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO dto) {
        return Usuario.builder()
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .activo(true)
                .build();
    }

    public UsuarioResponseDTO toDTO(Usuario entity) {
        return UsuarioResponseDTO.builder()
                .idUsuario(entity.getIdUsuario())
                .nombre(entity.getNombre())
                .email(entity.getEmail())
                .activo(entity.getActivo())
                .build();
    }
}
