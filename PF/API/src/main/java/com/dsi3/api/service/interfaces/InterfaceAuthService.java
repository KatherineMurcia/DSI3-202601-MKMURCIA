package com.dsi3.api.service.interfaces;

import com.dsi3.api.model.dto.AuthLoginRequestDTO;
import com.dsi3.api.model.dto.AuthRegistroRequestDTO;
import com.dsi3.api.model.dto.AuthResponseDTO;

public interface InterfaceAuthService {

    AuthResponseDTO registro(AuthRegistroRequestDTO dto);
    AuthResponseDTO login(AuthLoginRequestDTO dto);
}
