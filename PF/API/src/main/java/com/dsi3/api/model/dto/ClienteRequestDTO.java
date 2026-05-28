package com.dsi3.api.model.dto;

import java.time.LocalDateTime;

public class ClienteRequestDTO {

    private String        nombre;
    private String        telefono;
    private String        email;
    private LocalDateTime fechaRegistro;

    public ClienteRequestDTO() {}

    public String        getNombre()        { return nombre; }
    public void          setNombre(String v)           { this.nombre        = v; }
    public String        getTelefono()      { return telefono; }
    public void          setTelefono(String v)         { this.telefono      = v; }
    public String        getEmail()         { return email; }
    public void          setEmail(String v)            { this.email         = v; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void          setFechaRegistro(LocalDateTime v) { this.fechaRegistro = v; }
}
