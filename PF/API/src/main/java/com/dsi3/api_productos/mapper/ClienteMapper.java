package com.dsi3.api_productos.mapper;

import com.dsi3.api_productos.model.dto.ClienteRequestDTO;
import com.dsi3.api_productos.model.dto.ClienteResponseDTO;
import com.dsi3.api_productos.model.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteRequestDTO dto) {
        Cliente c = new Cliente();
        c.setNombre(dto.getNombre());
        c.setTelefono(dto.getTelefono());
        c.setEmail(dto.getEmail());
        c.setFechaRegistro(dto.getFechaRegistro());
        return c;
    }

    public Cliente toEntity(ClienteRequestDTO dto, Long id) {
        Cliente c = toEntity(dto);
        c.setIdCliente(id);
        return c;
    }

    public ClienteResponseDTO toResponseDTO(Cliente e) {
        return new ClienteResponseDTO(e.getIdCliente(), e.getNombre(),
                e.getTelefono(), e.getEmail(), e.getFechaRegistro());
    }
}
