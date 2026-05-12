package com.dsi3.calculadora.service.interfaces;

import com.dsi3.calculadora.model.dto.TrigonometriaRequestDTO;
import com.dsi3.calculadora.model.dto.TrigonometriaResponseDTO;
import org.springframework.http.ResponseEntity;

public interface ITrigonometriaService {
    ResponseEntity<TrigonometriaResponseDTO> calcularSeno(TrigonometriaRequestDTO request);
    ResponseEntity<TrigonometriaResponseDTO> calcularCoseno(TrigonometriaRequestDTO request);
    ResponseEntity<TrigonometriaResponseDTO> calcularTangente(TrigonometriaRequestDTO request);
    ResponseEntity<TrigonometriaResponseDTO> calcularCosecante(TrigonometriaRequestDTO request);
    ResponseEntity<TrigonometriaResponseDTO> calcularSecante(TrigonometriaRequestDTO request);
    ResponseEntity<TrigonometriaResponseDTO> calcularCotangente(TrigonometriaRequestDTO request);
}
