package com.dsi3.api_usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi3.api_usuarios.model.entity.Usuario;

public interface InterfaceUsuarioRepository extends JpaRepository<Usuario, Long>{

}
