package com.dsi3.calculadora.controller.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dsi3.calculadora.controller.interfaces.ITrigonometriaController;
import com.dsi3.calculadora.model.dto.TrigonometriaRequestDTO;
import com.dsi3.calculadora.model.dto.TrigonometriaResponseDTO;
import com.dsi3.calculadora.service.interfaces.ITrigonometriaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TrigonometriaController implements ITrigonometriaController {

    private final ITrigonometriaService trigonometriaService;

    @Override
    public ResponseEntity<TrigonometriaResponseDTO> calcularSeno(TrigonometriaRequestDTO request) {
        return trigonometriaService.calcularSeno(request);
    }

    @Override
    public ResponseEntity<TrigonometriaResponseDTO> calcularCoseno(TrigonometriaRequestDTO request) {
        return trigonometriaService.calcularCoseno(request);
    }

    @Override
    public ResponseEntity<TrigonometriaResponseDTO> calcularTangente(TrigonometriaRequestDTO request) {
        return trigonometriaService.calcularTangente(request);
    }

    @Override
    public ResponseEntity<TrigonometriaResponseDTO> calcularCosecante(TrigonometriaRequestDTO request) {
        return trigonometriaService.calcularCosecante(request);
    }

    @Override
    public ResponseEntity<TrigonometriaResponseDTO> calcularSecante(TrigonometriaRequestDTO request) {
        return trigonometriaService.calcularSecante(request);
    }

    @Override
    public ResponseEntity<TrigonometriaResponseDTO> calcularCotangente(TrigonometriaRequestDTO request) {
        return trigonometriaService.calcularCotangente(request);
    }
}
