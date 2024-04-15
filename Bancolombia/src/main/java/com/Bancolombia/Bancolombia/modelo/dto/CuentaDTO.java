package com.Bancolombia.Bancolombia.modelo.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CuentaDTO {
    private String numeroCuenta;
    private String tipoCuenta;
    private Double saldo;
    private String titular;
    private String documento;
}
