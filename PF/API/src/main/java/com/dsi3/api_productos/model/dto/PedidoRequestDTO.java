package com.dsi3.api_productos.model.dto;

import java.util.List;

public class PedidoRequestDTO {

    private Long         idMesa;
    private Long         idCliente;
    private Long         idUsuario;
    private String       observaciones;
    private List<ItemDTO> items;

    public PedidoRequestDTO() {}

    public Long          getIdMesa()        { return idMesa; }
    public void          setIdMesa(Long v)          { this.idMesa        = v; }
    public Long          getIdCliente()     { return idCliente; }
    public void          setIdCliente(Long v)       { this.idCliente     = v; }
    public Long          getIdUsuario()     { return idUsuario; }
    public void          setIdUsuario(Long v)       { this.idUsuario     = v; }
    public String        getObservaciones() { return observaciones; }
    public void          setObservaciones(String v) { this.observaciones = v; }
    public List<ItemDTO> getItems()         { return items; }
    public void          setItems(List<ItemDTO> v)  { this.items         = v; }

    public static class ItemDTO {
        private Long    idProducto;
        private Integer cantidad;

        public ItemDTO() {}

        public Long    getIdProducto() { return idProducto; }
        public void    setIdProducto(Long v)    { this.idProducto = v; }
        public Integer getCantidad()   { return cantidad; }
        public void    setCantidad(Integer v)   { this.cantidad   = v; }
    }
}
