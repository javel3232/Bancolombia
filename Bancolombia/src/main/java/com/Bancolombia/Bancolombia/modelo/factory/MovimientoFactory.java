package com.Bancolombia.Bancolombia.modelo.factory;

import com.Bancolombia.Bancolombia.modelo.entity.Cuenta;
import com.Bancolombia.Bancolombia.modelo.entity.Movimiento;
import com.Bancolombia.Bancolombia.modelo.dto.MovimientoDTO;

import java.util.HashSet;
import java.util.Set;

public class MovimientoFactory {

    public static MovimientoDTO buildMovimientoDTO(Movimiento movimiento){
        return MovimientoDTO.builder()

                .id(movimiento.getId())
                .claseMovimiento(movimiento.getClaseMovimiento())
                .sucursal(movimiento.getSucursal())
                .fecha(movimiento.getFecha())
                .valor(movimiento.getValor())
                .numeroCuenta(movimiento.getNumeroCuenta())
                .build();
    }

    public static Movimiento buildMovientoEntity(MovimientoDTO movimientoDTO, Cuenta cuenta){
       return Movimiento.builder()
               .cuenta(cuenta)
               .claseMovimiento(movimientoDTO.getClaseMovimiento())
               .fecha(movimientoDTO.getFecha())
               .valor(movimientoDTO.getValor())
               .sucursal(movimientoDTO.getSucursal())
               .numeroCuenta(movimientoDTO.getNumeroCuenta())
               .build();
    }

    public static Set<MovimientoDTO> buildMovimientosDTO(Set<Movimiento> movimientos){
        Set<MovimientoDTO> movimientosDTO = new HashSet<>();
        movimientos.forEach(moviento -> movimientosDTO.add(buildMovimientoDTO(moviento)));
        return movimientosDTO;
    }
}
