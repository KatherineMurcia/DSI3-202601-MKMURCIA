package com.dsi3.api.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;
    private String email;
    private String passwordHash;
    private Boolean activo;

    public Usuario() {}

    public Usuario(Long idUsuario, String nombre, String email,
                   String passwordHash, Boolean activo) {
        this.idUsuario    = idUsuario;
        this.nombre       = nombre;
        this.email        = email;
        this.passwordHash = passwordHash;
        this.activo       = activo;
    }

    public Long    getIdUsuario()    { return idUsuario; }
    public void    setIdUsuario(Long v)      { this.idUsuario    = v; }
    public String  getNombre()       { return nombre; }
    public void    setNombre(String v)       { this.nombre       = v; }
    public String  getEmail()        { return email; }
    public void    setEmail(String v)        { this.email        = v; }
    public String  getPasswordHash() { return passwordHash; }
    public void    setPasswordHash(String v) { this.passwordHash = v; }
    public Boolean getActivo()       { return activo; }
    public void    setActivo(Boolean v)      { this.activo       = v; }
}
