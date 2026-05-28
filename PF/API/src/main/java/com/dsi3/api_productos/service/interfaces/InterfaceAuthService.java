package com.dsi3.api_productos.service.interfaces;

import com.dsi3.api_productos.model.dto.AuthLoginRequestDTO;
import com.dsi3.api_productos.model.dto.AuthRegistroRequestDTO;
import com.dsi3.api_productos.model.dto.AuthResponseDTO;

public interface InterfaceAuthService {

    AuthResponseDTO registro(AuthRegistroRequestDTO dto);
    AuthResponseDTO login(AuthLoginRequestDTO dto);
}
