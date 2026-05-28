package com.dsi3.api.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;

    public DetallePedido() {}

    public DetallePedido(Long idDetalle, Pedido pedido, Producto producto,
                         Integer cantidad, Double precioUnitario, Double subtotal) {
        this.idDetalle      = idDetalle;
        this.pedido         = pedido;
        this.producto       = producto;
        this.cantidad       = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal       = subtotal;
    }

    public Long     getIdDetalle()      { return idDetalle; }
    public void     setIdDetalle(Long v)         { this.idDetalle      = v; }
    public Pedido   getPedido()         { return pedido; }
    public void     setPedido(Pedido v)          { this.pedido         = v; }
    public Producto getProducto()       { return producto; }
    public void     setProducto(Producto v)      { this.producto       = v; }
    public Integer  getCantidad()       { return cantidad; }
    public void     setCantidad(Integer v)       { this.cantidad       = v; }
    public Double   getPrecioUnitario() { return precioUnitario; }
    public void     setPrecioUnitario(Double v)  { this.precioUnitario = v; }
    public Double   getSubtotal()       { return subtotal; }
    public void     setSubtotal(Double v)        { this.subtotal       = v; }
}
