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
        double resultado = calcularSenoInterno(request.getX());
        return ResponseEntity.ok(new TrigonometriaResponseDTO(resultado, "seno"));
    }

    @Override
    public ResponseEntity<TrigonometriaResponseDTO> calcularCoseno(TrigonometriaRequestDTO request) {
        double resultado = calcularCosenoInterno(request.getX());
        return ResponseEntity.ok(new TrigonometriaResponseDTO(resultado, "coseno"));
    }

    @Override
    public ResponseEntity<TrigonometriaResponseDTO> calcularTangente(TrigonometriaRequestDTO request) {
        double seno = calcularSenoInterno(request.getX());
        double coseno = calcularCosenoInterno(request.getX());
        return ResponseEntity.ok(new TrigonometriaResponseDTO(seno / coseno, "tangente"));
    }

    @Override
    public ResponseEntity<TrigonometriaResponseDTO> calcularCosecante(TrigonometriaRequestDTO request) {
        double seno = calcularSenoInterno(request.getX());
        return ResponseEntity.ok(new TrigonometriaResponseDTO(1.0 / seno, "cosecante"));
    }

    @Override
    public ResponseEntity<TrigonometriaResponseDTO> calcularSecante(TrigonometriaRequestDTO request) {
        double coseno = calcularCosenoInterno(request.getX());
        return ResponseEntity.ok(new TrigonometriaResponseDTO(1.0 / coseno, "secante"));
    }

    @Override
    public ResponseEntity<TrigonometriaResponseDTO> calcularCotangente(TrigonometriaRequestDTO request) {
        double seno = calcularSenoInterno(request.getX());
        double coseno = calcularCosenoInterno(request.getX());
        return ResponseEntity.ok(new TrigonometriaResponseDTO(coseno / seno, "cotangente"));
    }

    private double calcularSenoInterno(double grados) {
        double x = Math.toRadians(grados);
        double resultado = 0.0;
        for (int n = 0; n < TERMINOS; n++) {
            resultado += Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / factorial(2 * n + 1);
        }
        return resultado;
    }

    private double calcularCosenoInterno(double grados) {
        double x = Math.toRadians(grados);
        double resultado = 0.0;
        for (int n = 0; n < TERMINOS; n++) {
            resultado += Math.pow(-1, n) * Math.pow(x, 2 * n) / factorial(2 * n);
        }
        return resultado;
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
