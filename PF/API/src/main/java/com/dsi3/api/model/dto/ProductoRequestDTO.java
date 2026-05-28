package com.dsi3.api.model.dto;

public class ProductoRequestDTO {

    private String nombre;
    private String descripcion;
    private Double precio;
    private String categoria;
    private String imagenUrl;
    private Boolean disponible;
    private Integer stock;

    public ProductoRequestDTO() {}

    public ProductoRequestDTO(String nombre, String descripcion, Double precio,
                               String categoria, String imagenUrl, Boolean disponible, Integer stock) {
        this.nombre      = nombre;
        this.descripcion = descripcion;
        this.precio      = precio;
        this.categoria   = categoria;
        this.imagenUrl   = imagenUrl;
        this.disponible  = disponible;
        this.stock       = stock;
    }

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
}
