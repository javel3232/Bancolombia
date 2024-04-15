package com.Bancolombia.Bancolombia.modelo.factory;

import com.Bancolombia.Bancolombia.modelo.dto.CuentaDTO;
import com.Bancolombia.Bancolombia.modelo.entity.Cuenta;

import java.util.HashSet;
import java.util.Set;

public class CuentaFactory {

    public static CuentaDTO buildCuentaDTO(Cuenta cuenta){
        return CuentaDTO.builder()
                .numeroCuenta(cuenta.getNumeroCuenta())
                .tipoCuenta(cuenta.getTipoCuenta())
                .saldo(cuenta.getSaldo())
                .titular(cuenta.getTitular())
                .documento(cuenta.getDocumento())
                .build();
    }

    public static Cuenta buildCuentaEntity(CuentaDTO cuentaDTO){
        return Cuenta.builder()
                .numeroCuenta(cuentaDTO.getNumeroCuenta())
                .tipoCuenta(cuentaDTO.getTipoCuenta())
                .saldo(cuentaDTO.getSaldo())
                .titular(cuentaDTO.getTitular())
                .documento(cuentaDTO.getDocumento()).build();
    }

    public static Set<CuentaDTO> buildCuentasDTO(Set<Cuenta> cuentas){
        Set<CuentaDTO> cuentasDTO = new HashSet<>();
        cuentas.forEach(cuenta -> cuentasDTO.add(buildCuentaDTO(cuenta)));
        return cuentasDTO;
    }
}
