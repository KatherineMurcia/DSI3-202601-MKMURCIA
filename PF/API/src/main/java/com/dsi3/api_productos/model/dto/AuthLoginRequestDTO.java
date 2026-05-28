package com.dsi3.api_productos.model.dto;

public class AuthLoginRequestDTO {

    private String email;
    private String password;

    public AuthLoginRequestDTO() {}

    public String getEmail()    { return email; }
    public void   setEmail(String v)    { this.email    = v; }
    public String getPassword() { return password; }
    public void   setPassword(String v) { this.password = v; }
}
