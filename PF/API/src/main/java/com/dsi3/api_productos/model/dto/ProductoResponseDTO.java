package com.dsi3.api_productos.model.dto;

public class ProductoResponseDTO {

    private Long idProducto;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String categoria;
    private String imagenUrl;
    private Boolean disponible;
    private Integer stock;

    public ProductoResponseDTO() {}

    public ProductoResponseDTO(Long idProducto, String nombre, String descripcion, Double precio,
                                String categoria, String imagenUrl, Boolean disponible, Integer stock) {
        this.idProducto  = idProducto;
        this.nombre      = nombre;
        this.descripcion = descripcion;
        this.precio      = precio;
        this.categoria   = categoria;
        this.imagenUrl   = imagenUrl;
        this.disponible  = disponible;
        this.stock       = stock;
    }

    public Long    getIdProducto()  { return idProducto; }
    public void    setIdProducto(Long v)    { this.idProducto  = v; }
    public String  getNombre()      { return nombre; }
    public void    setNombre(String v)      { this.nombre      = v; }
    public String  getDescripcion() { return descripcion; }
    public void    setDescripcion(String v) { this.descripcion = v; }
    public Double  getPrecio()      { return precio; }
    public void    setPrecio(Double v)      { this.precio      = v; }
    public String  getCategoria()   { return categoria; }
    public void    setCategoria(String v)   { this.categoria   = v; }
    public String  getImagenUrl()   { return imagenUrl; }
    public void    setImagenUrl(String v)   { this.imagenUrl   = v; }
    public Boolean getDisponible()  { return disponible; }
    public void    setDisponible(Boolean v) { this.disponible  = v; }
    public Integer getStock()       { return stock; }
    public void    setStock(Integer v)      { this.stock       = v; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Long idProducto; private String nombre; private String descripcion;
        private Double precio; private String categoria; private String imagenUrl;
        private Boolean disponible; private Integer stock;

        public Builder idProducto(Long v)   { this.idProducto  = v; return this; }
        public Builder nombre(String v)     { this.nombre      = v; return this; }
        public Builder descripcion(String v){ this.descripcion = v; return this; }
        public Builder precio(Double v)     { this.precio      = v; return this; }
        public Builder categoria(String v)  { this.categoria   = v; return this; }
        public Builder imagenUrl(String v)  { this.imagenUrl   = v; return this; }
        public Builder disponible(Boolean v){ this.disponible  = v; return this; }
        public Builder stock(Integer v)     { this.stock       = v; return this; }
        public ProductoResponseDTO build() {
            return new ProductoResponseDTO(idProducto, nombre, descripcion, precio, categoria, imagenUrl, disponible, stock);
        }
    }
}
