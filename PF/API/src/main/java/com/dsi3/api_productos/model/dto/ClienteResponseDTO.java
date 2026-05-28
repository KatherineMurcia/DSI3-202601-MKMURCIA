package com.dsi3.api_productos.model.dto;

import java.time.LocalDateTime;

public class ClienteResponseDTO {

    private Long          idCliente;
    private String        nombre;
    private String        telefono;
    private String        email;
    private LocalDateTime fechaRegistro;

    public ClienteResponseDTO() {}

    public ClienteResponseDTO(Long idCliente, String nombre, String telefono,
                               String email, LocalDateTime fechaRegistro) {
        this.idCliente     = idCliente;
        this.nombre        = nombre;
        this.telefono      = telefono;
        this.email         = email;
        this.fechaRegistro = fechaRegistro;
    }

    public Long          getIdCliente()     { return idCliente; }
    public void          setIdCliente(Long v)          { this.idCliente     = v; }
    public String        getNombre()        { return nombre; }
    public void          setNombre(String v)           { this.nombre        = v; }
    public String        getTelefono()      { return telefono; }
    public void          setTelefono(String v)         { this.telefono      = v; }
    public String        getEmail()         { return email; }
    public void          setEmail(String v)            { this.email         = v; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void          setFechaRegistro(LocalDateTime v) { this.fechaRegistro = v; }
}
