package com.Bancolombia.Bancolombia.modelo.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MovimientoDTO {
    private int id;
    private double valor;
    private String fecha;
    private String numeroCuenta;
    private String claseMovimiento;
    private String sucursal;
}
