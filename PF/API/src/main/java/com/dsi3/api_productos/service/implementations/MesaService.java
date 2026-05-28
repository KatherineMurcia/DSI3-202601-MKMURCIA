package com.dsi3.api_productos.service.implementations;

import com.dsi3.api_productos.mapper.MesaMapper;
import com.dsi3.api_productos.model.dto.MesaRequestDTO;
import com.dsi3.api_productos.model.dto.MesaResponseDTO;
import com.dsi3.api_productos.repository.InterfaceMesaRepository;
import com.dsi3.api_productos.repository.InterfacePedidoRepository;
import com.dsi3.api_productos.service.interfaces.InterfaceMesaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MesaService implements InterfaceMesaService {

    private final InterfaceMesaRepository   mesaRepo;
    private final InterfacePedidoRepository pedidoRepo;
    private final MesaMapper                mapper;

    public MesaService(InterfaceMesaRepository mesaRepo,
                       InterfacePedidoRepository pedidoRepo,
                       MesaMapper mapper) {
        this.mesaRepo   = mesaRepo;
        this.pedidoRepo = pedidoRepo;
        this.mapper     = mapper;
    }

    @Override
    public List<MesaResponseDTO> findAll(String estado) {
        List<?> source = (estado != null && !estado.isBlank())
                ? mesaRepo.findByEstado(estado)
                : mesaRepo.findAll();
        return ((List<com.dsi3.api_productos.model.entity.Mesa>) source)
                .stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public MesaResponseDTO findById(Long id) {
        return mesaRepo.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada con id: " + id));
    }

    @Override
    public MesaResponseDTO save(MesaRequestDTO dto) {
        return mapper.toResponseDTO(mesaRepo.save(mapper.toEntity(dto)));
    }

    @Override
    public MesaResponseDTO update(Long id, MesaRequestDTO dto) {
        mesaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada con id: " + id));
        return mapper.toResponseDTO(mesaRepo.save(mapper.toEntity(dto, id)));
    }

    @Override
    public void delete(Long id) {
        mesaRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada con id: " + id));
        boolean tieneActivos = pedidoRepo.existsByMesa_IdMesaAndEstadoIn(
                id, List.of("Creada", "En preparación"));
        if (tieneActivos) {
            throw new RuntimeException("La mesa tiene pedidos activos y no puede eliminarse");
        }
        mesaRepo.deleteById(id);
    }
}
