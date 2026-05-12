package com.dsi3.calculadora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TrigonometriaRequestDTO {
 private Double x; //Dato en grados , Taylor en radianes
}

