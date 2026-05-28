package com.dsi3.api.mapper;

import com.dsi3.api.model.dto.MesaRequestDTO;
import com.dsi3.api.model.dto.MesaResponseDTO;
import com.dsi3.api.model.entity.Mesa;
import org.springframework.stereotype.Component;

@Component
public class MesaMapper {

    public Mesa toEntity(MesaRequestDTO dto) {
        Mesa m = new Mesa();
        m.setNumero(dto.getNumero());
        m.setCapacidad(dto.getCapacidad());
        m.setEstado(dto.getEstado());
        return m;
    }

    public Mesa toEntity(MesaRequestDTO dto, Long id) {
        Mesa m = toEntity(dto);
        m.setIdMesa(id);
        return m;
    }

    public MesaResponseDTO toResponseDTO(Mesa e) {
        return new MesaResponseDTO(e.getIdMesa(), e.getNumero(), e.getCapacidad(), e.getEstado());
    }
}
