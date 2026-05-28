package com.dsi3.api_productos.model.dto;

public class MesaRequestDTO {

    private Integer numero;
    private Integer capacidad;
    private String  estado;

    public MesaRequestDTO() {}

    public Integer getNumero()    { return numero; }
    public void    setNumero(Integer v)    { this.numero    = v; }
    public Integer getCapacidad() { return capacidad; }
    public void    setCapacidad(Integer v) { this.capacidad = v; }
    public String  getEstado()    { return estado; }
    public void    setEstado(String v)     { this.estado    = v; }
}
