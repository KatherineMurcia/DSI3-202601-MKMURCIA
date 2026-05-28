package com.dsi3.api_productos.service.implementations;

import com.dsi3.api_productos.mapper.ProductoMapper;
import com.dsi3.api_productos.model.dto.ProductoRequestDTO;
import com.dsi3.api_productos.model.dto.ProductoResponseDTO;
import com.dsi3.api_productos.repository.InterfaceProductoRepository;
import com.dsi3.api_productos.service.interfaces.InterfaceProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements InterfaceProductoService {

    private final InterfaceProductoRepository repository;
    private final ProductoMapper mapper;

    public ProductoService(InterfaceProductoRepository repository, ProductoMapper mapper) {
        this.repository = repository;
        this.mapper     = mapper;
    }

    @Override
    public List<ProductoResponseDTO> findAll(String categoria, Boolean disponible) {
        List<com.dsi3.api_productos.model.entity.Producto> list;
        if (categoria != null && !categoria.isBlank() && disponible != null) {
            list = repository.findByCategoriaAndDisponible(categoria, disponible);
        } else if (categoria != null && !categoria.isBlank()) {
            list = repository.findByCategoria(categoria);
        } else if (disponible != null) {
            list = repository.findByDisponible(disponible);
        } else {
            list = repository.findAll();
        }
        return list.stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public ProductoResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    @Override
    public ProductoResponseDTO save(ProductoRequestDTO dto) {
        return mapper.toResponseDTO(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public ProductoResponseDTO update(Long id, ProductoRequestDTO dto) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        return mapper.toResponseDTO(repository.save(mapper.toEntity(dto, id)));
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        repository.deleteById(id);
    }
}
