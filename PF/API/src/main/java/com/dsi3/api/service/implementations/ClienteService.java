package com.dsi3.api.service.implementations;

import com.dsi3.api.mapper.ClienteMapper;
import com.dsi3.api.model.dto.ClienteRequestDTO;
import com.dsi3.api.model.dto.ClienteResponseDTO;
import com.dsi3.api.repository.InterfaceClienteRepository;
import com.dsi3.api.service.interfaces.InterfaceClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService implements InterfaceClienteService {

    private final InterfaceClienteRepository repo;
    private final ClienteMapper              mapper;

    public ClienteService(InterfaceClienteRepository repo, ClienteMapper mapper) {
        this.repo   = repo;
        this.mapper = mapper;
    }

    @Override
    public List<ClienteResponseDTO> findAll(String busqueda) {
        List<com.dsi3.api.model.entity.Cliente> clientes =
                (busqueda != null && !busqueda.isBlank())
                        ? repo.findByNombreContainingIgnoreCaseOrEmailContainingIgnoreCase(busqueda, busqueda)
                        : repo.findAll();
        return clientes.stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        return repo.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
    }

    @Override
    public ClienteResponseDTO save(ClienteRequestDTO dto) {
        return mapper.toResponseDTO(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public ClienteResponseDTO update(Long id, ClienteRequestDTO dto) {
        repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
        return mapper.toResponseDTO(repo.save(mapper.toEntity(dto, id)));
    }

    @Override
    public void delete(Long id) {
        repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + id));
        repo.deleteById(id);
    }
}
