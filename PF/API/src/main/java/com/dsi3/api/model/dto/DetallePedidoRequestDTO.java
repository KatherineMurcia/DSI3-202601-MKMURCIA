package com.dsi3.api.model.dto;

public class DetallePedidoRequestDTO {

    private Long    idProducto;
    private Integer cantidad;

    public DetallePedidoRequestDTO() {}

    public Long    getIdProducto() { return idProducto; }
    public void    setIdProducto(Long v)    { this.idProducto = v; }
    public Integer getCantidad()   { return cantidad; }
    public void    setCantidad(Integer v)   { this.cantidad   = v; }
}
