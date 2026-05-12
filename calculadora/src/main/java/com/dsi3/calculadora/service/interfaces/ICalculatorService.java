package com.dsi3.calculadora.service.interfaces;

import com.dsi3.calculadora.model.dto.CalculadoraRequestDTO;
import com.dsi3.calculadora.model.dto.CalculadoraResponseDTO;

public interface ICalculatorService {
    public CalculadoraResponseDTO operacionesBasicas(CalculadoraRequestDTO valores, int operacion);

}
