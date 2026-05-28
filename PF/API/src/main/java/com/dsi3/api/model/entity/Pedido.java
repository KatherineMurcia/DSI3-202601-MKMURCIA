package com.dsi3.api.model.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private LocalDateTime fechaCreacion;
    private String estado;
    private String observaciones;
    private Double total;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DetallePedido> detalles = new ArrayList<>();

    public Pedido() {}

    public Long          getIdPedido()      { return idPedido; }
    public void          setIdPedido(Long v)           { this.idPedido      = v; }
    public Mesa          getMesa()          { return mesa; }
    public void          setMesa(Mesa v)               { this.mesa          = v; }
    public Cliente       getCliente()       { return cliente; }
    public void          setCliente(Cliente v)         { this.cliente       = v; }
    public Usuario       getUsuario()       { return usuario; }
    public void          setUsuario(Usuario v)         { this.usuario       = v; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void          setFechaCreacion(LocalDateTime v) { this.fechaCreacion = v; }
    public String        getEstado()        { return estado; }
    public void          setEstado(String v)           { this.estado        = v; }
    public String        getObservaciones() { return observaciones; }
    public void          setObservaciones(String v)    { this.observaciones = v; }
    public Double        getTotal()         { return total; }
    public void          setTotal(Double v)            { this.total         = v; }
    public List<DetallePedido> getDetalles() { return detalles; }
    public void          setDetalles(List<DetallePedido> v) { this.detalles = v; }
}
