package com.Bancolombia.Bancolombia.servicio;



import com.Bancolombia.Bancolombia.modelo.dto.MovimientoDTO;

import java.util.Set;

public interface MovimientoService {

	MovimientoDTO registrarMovimiento(MovimientoDTO movimiento);

	MovimientoDTO actualizarMovimiento(MovimientoDTO movimiento);

	Set<MovimientoDTO> obtenerMovimientos();
	Set<MovimientoDTO> obtenerMovimientosPorCuenta(String numeroCuenta);
	MovimientoDTO obtenerMovimiento(int id);

	void eliminarMovimiento(int id);
}
