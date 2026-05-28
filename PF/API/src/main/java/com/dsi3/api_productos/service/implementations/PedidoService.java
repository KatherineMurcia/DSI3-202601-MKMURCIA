package com.dsi3.api_productos.service.implementations;

import com.dsi3.api_productos.mapper.PedidoMapper;
import com.dsi3.api_productos.model.dto.DetallePedidoRequestDTO;
import com.dsi3.api_productos.model.dto.DetallePedidoResponseDTO;
import com.dsi3.api_productos.model.dto.PedidoRequestDTO;
import com.dsi3.api_productos.model.dto.PedidoResponseDTO;
import com.dsi3.api_productos.model.entity.*;
import com.dsi3.api_productos.repository.*;
import com.dsi3.api_productos.service.interfaces.InterfacePedidoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService implements InterfacePedidoService {

    private final InterfacePedidoRepository      pedidoRepo;
    private final InterfaceMesaRepository        mesaRepo;
    private final InterfaceClienteRepository     clienteRepo;
    private final InterfaceUsuarioRepository     usuarioRepo;
    private final InterfaceProductoRepository    productoRepo;
    private final InterfaceDetallePedidoRepository detalleRepo;
    private final PedidoMapper                   mapper;

    public PedidoService(InterfacePedidoRepository pedidoRepo,
                         InterfaceMesaRepository mesaRepo,
                         InterfaceClienteRepository clienteRepo,
                         InterfaceUsuarioRepository usuarioRepo,
                         InterfaceProductoRepository productoRepo,
                         InterfaceDetallePedidoRepository detalleRepo,
                         PedidoMapper mapper) {
        this.pedidoRepo  = pedidoRepo;
        this.mesaRepo    = mesaRepo;
        this.clienteRepo = clienteRepo;
        this.usuarioRepo = usuarioRepo;
        this.productoRepo = productoRepo;
        this.detalleRepo = detalleRepo;
        this.mapper      = mapper;
    }

    @Override
    public List<PedidoResponseDTO> findAll(String estado) {
        List<Pedido> pedidos = (estado != null && !estado.isBlank())
                ? pedidoRepo.findByEstado(estado)
                : pedidoRepo.findAll();
        return pedidos.stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        return pedidoRepo.findById(id)
                .map(mapper::toResponseDTO)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id: " + id));
    }

    @Override
    public PedidoResponseDTO save(PedidoRequestDTO dto) {
        Mesa mesa = mesaRepo.findById(dto.getIdMesa())
                .orElseThrow(() -> new RuntimeException("Mesa no encontrada con id: " + dto.getIdMesa()));

        Cliente cliente = null;
        if (dto.getIdCliente() != null) {
            cliente = clienteRepo.findById(dto.getIdCliente())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + dto.getIdCliente()));
        }

        Usuario usuario = null;
        if (dto.getIdUsuario() != null) {
            usuario = usuarioRepo.findById(dto.getIdUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + dto.getIdUsuario()));
        }

        Pedido pedido = new Pedido();
        pedido.setMesa(mesa);
        pedido.setCliente(cliente);
        pedido.setUsuario(usuario);
        pedido.setFechaCreacion(LocalDateTime.now());
        pedido.setEstado("Creada");
        pedido.setObservaciones(dto.getObservaciones());
        pedido.setTotal(0.0);
        Pedido saved = pedidoRepo.save(pedido);

        double total = 0.0;
        if (dto.getItems() != null) {
            for (PedidoRequestDTO.ItemDTO item : dto.getItems()) {
                Producto producto = productoRepo.findById(item.getIdProducto())
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + item.getIdProducto()));
                DetallePedido detalle = new DetallePedido();
                detalle.setPedido(saved);
                detalle.setProducto(producto);
                detalle.setCantidad(item.getCantidad());
                detalle.setPrecioUnitario(producto.getPrecio());
                detalle.setSubtotal(producto.getPrecio() * item.getCantidad());
                DetallePedido savedDetalle = detalleRepo.save(detalle);
                saved.getDetalles().add(savedDetalle);
                total += savedDetalle.getSubtotal();
            }
        }

        mesa.setEstado("Ocupada");
        mesaRepo.save(mesa);

        saved.setTotal(total);
        pedidoRepo.save(saved);

        return mapper.toResponseDTO(saved);
    }

    @Override
    public void delete(Long id) {
        Pedido pedido = pedidoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id: " + id));
        if (!"Creada".equals(pedido.getEstado())) {
            throw new RuntimeException("Solo se pueden eliminar pedidos en estado 'Creada'");
        }
        pedidoRepo.deleteById(id);
    }

    @Override
    public PedidoResponseDTO avanzarEstado(Long id) {
        Pedido pedido = pedidoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id: " + id));

        String nuevoEstado = switch (pedido.getEstado()) {
            case "Creada"         -> "En preparación";
            case "En preparación" -> "Entregada";
            default -> throw new RuntimeException("El pedido ya está en estado final: " + pedido.getEstado());
        };

        pedido.setEstado(nuevoEstado);

        if ("Entregada".equals(nuevoEstado) && pedido.getMesa() != null) {
            pedido.getMesa().setEstado("Disponible");
            mesaRepo.save(pedido.getMesa());
        }

        return mapper.toResponseDTO(pedidoRepo.save(pedido));
    }

    @Override
    public DetallePedidoResponseDTO agregarDetalle(Long idPedido, DetallePedidoRequestDTO dto) {
        Pedido pedido = pedidoRepo.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id: " + idPedido));
        if ("Entregada".equals(pedido.getEstado())) {
            throw new RuntimeException("No se pueden agregar ítems a un pedido entregado");
        }
        Producto producto = productoRepo.findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + dto.getIdProducto()));

        DetallePedido detalle = new DetallePedido();
        detalle.setPedido(pedido);
        detalle.setProducto(producto);
        detalle.setCantidad(dto.getCantidad());
        detalle.setPrecioUnitario(producto.getPrecio());
        detalle.setSubtotal(producto.getPrecio() * dto.getCantidad());
        detalleRepo.save(detalle);

        recalcularTotal(pedidoRepo.findById(idPedido).get());

        return mapper.toDetalleDTO(detalle);
    }

    @Override
    public void eliminarDetalle(Long idPedido, Long idDetalle) {
        Pedido pedido = pedidoRepo.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con id: " + idPedido));
        if (!"Creada".equals(pedido.getEstado())) {
            throw new RuntimeException("Solo se pueden eliminar ítems de pedidos en estado 'Creada'");
        }
        detalleRepo.deleteById(idDetalle);
        recalcularTotal(pedidoRepo.findById(idPedido).get());
    }

    private void recalcularTotal(Pedido pedido) {
        double total = pedido.getDetalles().stream()
                .mapToDouble(d -> d.getSubtotal() != null ? d.getSubtotal() : 0.0)
                .sum();
        pedido.setTotal(total);
        pedidoRepo.save(pedido);
    }
}
