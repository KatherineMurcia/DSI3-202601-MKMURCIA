package com.dsi3.calculadora.service.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dsi3.calculadora.model.dto.TrigonometriaRequestDTO;
import com.dsi3.calculadora.model.dto.TrigonometriaResponseDTO;
import com.dsi3.calculadora.service.interfaces.ITrigonometriaService;

@Service
public class TrigonometriaService implements ITrigonometriaService {

    private static final int TERMINOS = 7;

    @Override
    public ResponseEntity<TrigonometriaResponseDTO> calcularSeno(TrigonometriaRequestDTO request) {
        double x = Math.toRadians(request.getX());
        double resultado = 0.0;

        for (int n = 0; n < TERMINOS; n++) {
            resultado += Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / factorial(2 * n + 1);
        }

        return ResponseEntity.ok(new TrigonometriaResponseDTO(resultado, "seno"));
    }

    @Override
    public ResponseEntity<TrigonometriaResponseDTO> calcularCoseno(TrigonometriaRequestDTO request) {
        double x = Math.toRadians(request.getX());
        double resultado = 0.0;

        for (int n = 0; n < TERMINOS; n++) {
            resultado += Math.pow(-1, n) * Math.pow(x, 2 * n) / factorial(2 * n);
        }

        return ResponseEntity.ok(new TrigonometriaResponseDTO(resultado, "coseno"));
    }

    private double factorial(int n) {
        if (n == 0) return 1;
        double resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
