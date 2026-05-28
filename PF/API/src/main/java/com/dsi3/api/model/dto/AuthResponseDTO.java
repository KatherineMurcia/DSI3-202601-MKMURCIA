package com.dsi3.api.model.dto;

public class AuthResponseDTO {

    private Long   idUsuario;
    private String nombre;
    private String email;

    public AuthResponseDTO() {}

    public AuthResponseDTO(Long idUsuario, String nombre, String email) {
        this.idUsuario = idUsuario;
        this.nombre    = nombre;
        this.email     = email;
    }

    public Long   getIdUsuario() { return idUsuario; }
    public void   setIdUsuario(Long v)   { this.idUsuario = v; }
    public String getNombre()    { return nombre; }
    public void   setNombre(String v)    { this.nombre    = v; }
    public String getEmail()     { return email; }
    public void   setEmail(String v)     { this.email     = v; }
}
