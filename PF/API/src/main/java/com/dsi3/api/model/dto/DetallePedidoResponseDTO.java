package com.dsi3.api.model.dto;

public class DetallePedidoResponseDTO {

    private Long               idDetalle;
    private ProductoResponseDTO producto;
    private Integer            cantidad;
    private Double             precioUnitario;
    private Double             subtotal;

    public DetallePedidoResponseDTO() {}

    public DetallePedidoResponseDTO(Long idDetalle, ProductoResponseDTO producto,
                                     Integer cantidad, Double precioUnitario, Double subtotal) {
        this.idDetalle      = idDetalle;
        this.producto       = producto;
        this.cantidad       = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal       = subtotal;
    }

    public Long                getIdDetalle()      { return idDetalle; }
    public void                setIdDetalle(Long v)         { this.idDetalle      = v; }
    public ProductoResponseDTO getProducto()       { return producto; }
    public void                setProducto(ProductoResponseDTO v) { this.producto = v; }
    public Integer             getCantidad()       { return cantidad; }
    public void                setCantidad(Integer v)       { this.cantidad       = v; }
    public Double              getPrecioUnitario() { return precioUnitario; }
    public void                setPrecioUnitario(Double v)  { this.precioUnitario = v; }
    public Double              getSubtotal()       { return subtotal; }
    public void                setSubtotal(Double v)        { this.subtotal       = v; }
}
