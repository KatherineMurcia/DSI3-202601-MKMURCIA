package com.dsi3.api.model.dto;

public class MesaResponseDTO {

    private Long    idMesa;
    private Integer numero;
    private Integer capacidad;
    private String  estado;

    public MesaResponseDTO() {}

    public MesaResponseDTO(Long idMesa, Integer numero, Integer capacidad, String estado) {
        this.idMesa    = idMesa;
        this.numero    = numero;
        this.capacidad = capacidad;
        this.estado    = estado;
    }

    public Long    getIdMesa()    { return idMesa; }
    public void    setIdMesa(Long v)      { this.idMesa    = v; }
    public Integer getNumero()    { return numero; }
    public void    setNumero(Integer v)   { this.numero    = v; }
    public Integer getCapacidad() { return capacidad; }
    public void    setCapacidad(Integer v){ this.capacidad = v; }
    public String  getEstado()    { return estado; }
    public void    setEstado(String v)    { this.estado    = v; }
}
