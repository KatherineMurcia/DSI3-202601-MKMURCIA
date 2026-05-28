package com.dsi3.api.service.implementations;

import com.dsi3.api.model.dto.AuthLoginRequestDTO;
import com.dsi3.api.model.dto.AuthRegistroRequestDTO;
import com.dsi3.api.model.dto.AuthResponseDTO;
import com.dsi3.api.model.entity.Usuario;
import com.dsi3.api.repository.InterfaceUsuarioRepository;
import com.dsi3.api.service.interfaces.InterfaceAuthService;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class AuthService implements InterfaceAuthService {

    private final InterfaceUsuarioRepository repo;

    public AuthService(InterfaceUsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public AuthResponseDTO registro(AuthRegistroRequestDTO dto) {
        if (repo.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("El correo ya está registrado");
        }
        Usuario u = new Usuario();
        u.setNombre(dto.getNombre());
        u.setEmail(dto.getEmail());
        u.setPasswordHash(hash(dto.getPassword()));
        u.setActivo(true);
        u = repo.save(u);
        return new AuthResponseDTO(u.getIdUsuario(), u.getNombre(), u.getEmail());
    }

    @Override
    public AuthResponseDTO login(AuthLoginRequestDTO dto) {
        Usuario u = repo.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));
        if (!u.getPasswordHash().equals(hash(dto.getPassword()))) {
            throw new RuntimeException("Credenciales inválidas");
        }
        return new AuthResponseDTO(u.getIdUsuario(), u.getNombre(), u.getEmail());
    }

    private String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al procesar contraseña", e);
        }
    }
}
