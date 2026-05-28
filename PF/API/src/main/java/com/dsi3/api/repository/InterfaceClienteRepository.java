package com.dsi3.api.repository;

import com.dsi3.api.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InterfaceClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNombreContainingIgnoreCaseOrEmailContainingIgnoreCase(String nombre, String email);
    Optional<Cliente> findByEmail(String email);
}
