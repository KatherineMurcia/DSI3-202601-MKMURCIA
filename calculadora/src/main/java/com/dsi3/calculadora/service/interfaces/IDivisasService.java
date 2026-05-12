package com.dsi3.calculadora.service.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.dsi3.calculadora.model.dto.DivisasRequestDTO;
import com.dsi3.calculadora.model.dto.DivisasResponseDTO;
import com.dsi3.calculadora.model.dto.InteresCompuestoRequestDTO;
import com.dsi3.calculadora.model.dto.InteresCompuestoResponseDTO;

public interface IDivisasService {

    public ResponseEntity<DivisasResponseDTO> calcularDivisa(DivisasRequestDTO value); 

    ResponseEntity<InteresCompuestoResponseDTO> calcularInteresCompuesto(@RequestBody InteresCompuestoRequestDTO request);

}
