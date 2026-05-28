package com.dsi3.api.mapper;

import com.dsi3.api.model.dto.MesaRequestDTO;
import com.dsi3.api.model.dto.MesaResponseDTO;
import com.dsi3.api.model.entity.Mesa;
import org.springframework.stereotype.Component;

@Component
public class MesaMapper {

    public Mesa toEntity(MesaRequestDTO dto) {
        return Mesa.builder()
                .numero(dto.getNumero())
                .capacidad(dto.getCapacidad())
                .estado(dto.getEstado())
                .build();
    }

    public MesaResponseDTO toDTO(Mesa entity) {
        return MesaResponseDTO.builder()
                .idMesa(entity.getIdMesa())
                .numero(entity.getNumero())
                .capacidad(entity.getCapacidad())
                .estado(entity.getEstado())
                .build();
    }
}
