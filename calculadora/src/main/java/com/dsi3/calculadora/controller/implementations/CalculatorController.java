package com.dsi3.calculadora.controller.implementations;

import com.dsi3.calculadora.controller.interfaces.ICalculatorController;
import com.dsi3.calculadora.model.dto.CalculadoraRequestDTO;
import com.dsi3.calculadora.model.dto.CalculadoraResponseDTO;
import com.dsi3.calculadora.service.implementations.CalculatorService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CalculatorController implements ICalculatorController {

    private final CalculatorService calculatorService;
    

    @Override
    public ResponseEntity<CalculadoraResponseDTO> suma(CalculadoraRequestDTO request) {
        return ResponseEntity.ok(
            calculatorService.operacionesBasicas(request, 1)
        );
    }

    @Override
    public ResponseEntity<CalculadoraResponseDTO> resta(CalculadoraRequestDTO request) {
        return ResponseEntity.ok(
            calculatorService.operacionesBasicas(request, 2)
        );

    }

     @Override
    public ResponseEntity<CalculadoraResponseDTO> multiplicacion(CalculadoraRequestDTO request) {
        return ResponseEntity.ok(
            calculatorService.operacionesBasicas(request, 3)
        );
    }

    @Override
    public ResponseEntity<CalculadoraResponseDTO> division(CalculadoraRequestDTO request) {
        return ResponseEntity.ok(
            calculatorService.operacionesBasicas(request, 4)
        );
    }

}
