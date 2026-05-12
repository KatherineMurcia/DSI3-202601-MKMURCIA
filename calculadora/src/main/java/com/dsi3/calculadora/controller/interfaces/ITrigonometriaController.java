package com.dsi3.calculadora.controller.interfaces;

import com.dsi3.calculadora.model.dto.TrigonometriaRequestDTO;
import com.dsi3.calculadora.model.dto.TrigonometriaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/calculadora/trigonometria")
public interface ITrigonometriaController {

    @PostMapping("/seno")
    ResponseEntity<TrigonometriaResponseDTO> calcularSeno(@RequestBody TrigonometriaRequestDTO request);

    @PostMapping("/coseno")
    ResponseEntity<TrigonometriaResponseDTO> calcularCoseno(@RequestBody TrigonometriaRequestDTO request);

    @PostMapping("/tangente")
    ResponseEntity<TrigonometriaResponseDTO> calcularTangente(@RequestBody TrigonometriaRequestDTO request);

    @PostMapping("/cosecante")
    ResponseEntity<TrigonometriaResponseDTO> calcularCosecante(@RequestBody TrigonometriaRequestDTO request);

    @PostMapping("/secante")
    ResponseEntity<TrigonometriaResponseDTO> calcularSecante(@RequestBody TrigonometriaRequestDTO request);

    @PostMapping("/cotangente")
    ResponseEntity<TrigonometriaResponseDTO> calcularCotangente(@RequestBody TrigonometriaRequestDTO request);
}
