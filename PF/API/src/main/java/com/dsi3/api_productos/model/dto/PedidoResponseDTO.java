package com.dsi3.api_productos.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponseDTO {

    private Long                      idPedido;
    private MesaResponseDTO           mesa;
    private ClienteResponseDTO        cliente;
    private LocalDateTime             fechaCreacion;
    private String                    estado;
    private String                    observaciones;
    private List<DetallePedidoResponseDTO> detalles;
    private Double                    total;

    public PedidoResponseDTO() {}

    public PedidoResponseDTO(Long idPedido, MesaResponseDTO mesa, ClienteResponseDTO cliente,
                              LocalDateTime fechaCreacion, String estado, String observaciones,
                              List<DetallePedidoResponseDTO> detalles, Double total) {
        this.idPedido      = idPedido;
        this.mesa          = mesa;
        this.cliente       = cliente;
        this.fechaCreacion = fechaCreacion;
        this.estado        = estado;
        this.observaciones = observaciones;
        this.detalles      = detalles;
        this.total         = total;
    }

    public Long                           getIdPedido()      { return idPedido; }
    public void                           setIdPedido(Long v)           { this.idPedido      = v; }
    public MesaResponseDTO                getMesa()          { return mesa; }
    public void                           setMesa(MesaResponseDTO v)    { this.mesa          = v; }
    public ClienteResponseDTO             getCliente()       { return cliente; }
    public void                           setCliente(ClienteResponseDTO v) { this.cliente    = v; }
    public LocalDateTime                  getFechaCreacion() { return fechaCreacion; }
    public void                           setFechaCreacion(LocalDateTime v) { this.fechaCreacion = v; }
    public String                         getEstado()        { return estado; }
    public void                           setEstado(String v)           { this.estado        = v; }
    public String                         getObservaciones() { return observaciones; }
    public void                           setObservaciones(String v)    { this.observaciones = v; }
    public List<DetallePedidoResponseDTO> getDetalles()      { return detalles; }
    public void                           setDetalles(List<DetallePedidoResponseDTO> v) { this.detalles = v; }
    public Double                         getTotal()         { return total; }
    public void                           setTotal(Double v)            { this.total         = v; }
}
