package com.dsi3.calculadora.controller.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dsi3.calculadora.controller.interfaces.IFinancialController;
import com.dsi3.calculadora.model.dto.DivisasRequestDTO;
import com.dsi3.calculadora.model.dto.DivisasResponseDTO;
import com.dsi3.calculadora.model.dto.InteresCompuestoRequestDTO;
import com.dsi3.calculadora.model.dto.InteresCompuestoResponseDTO;
import com.dsi3.calculadora.service.interfaces.IDivisasService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class FinancialController implements IFinancialController {

    private final IDivisasService divisasService;

    @Override
    public ResponseEntity<DivisasResponseDTO> calcularDivisa(DivisasRequestDTO request) {
        return divisasService.calcularDivisa(request);
    }

    @Override
    public ResponseEntity<InteresCompuestoResponseDTO> calcularInteresCompuesto(InteresCompuestoRequestDTO request) {
        return divisasService.calcularInteresCompuesto(request);
    }

}
