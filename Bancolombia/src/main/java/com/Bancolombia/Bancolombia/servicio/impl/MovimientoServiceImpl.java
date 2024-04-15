package com.Bancolombia.Bancolombia.servicio.impl;

import com.Bancolombia.Bancolombia.modelo.dto.MovimientoDTO;
import com.Bancolombia.Bancolombia.modelo.factory.MovimientoFactory;
import com.Bancolombia.Bancolombia.repositorio.CuentaRepository;
import com.Bancolombia.Bancolombia.repositorio.MovimientoRepository;
import com.Bancolombia.Bancolombia.servicio.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class MovimientoServiceImpl implements MovimientoService {
    @Autowired
	private MovimientoRepository movimientoRepository;

	@Autowired
	CuentaRepository cuentaRepository;

	@Override
	public MovimientoDTO registrarMovimiento(MovimientoDTO movimiento) {

		var cuenta = cuentaRepository.findByNumeroCuenta(movimiento.getNumeroCuenta());
		var movimientoEntity = MovimientoFactory.buildMovientoEntity(movimiento, cuenta.get());
		var movimientoResponse =  movimientoRepository.save(movimientoEntity);
		return MovimientoFactory.buildMovimientoDTO(movimientoResponse);

	}

	@Override
	public MovimientoDTO actualizarMovimiento(MovimientoDTO movimiento) {
		var cuenta = cuentaRepository.findByNumeroCuenta(movimiento.getNumeroCuenta());
		var movimientoEntity = MovimientoFactory.buildMovientoEntity(movimiento, cuenta.get());
		var movimientoResponse =  movimientoRepository.save(movimientoEntity);
		return MovimientoFactory.buildMovimientoDTO(movimientoResponse);
	}

	@Override
	public Set<MovimientoDTO> obtenerMovimientos() {
		return MovimientoFactory.buildMovimientosDTO(new LinkedHashSet<>(movimientoRepository.findAll()));
	}
	@Override
	public Set<MovimientoDTO> obtenerMovimientosPorCuenta(String numeroCuenta) {
		return MovimientoFactory.buildMovimientosDTO(movimientoRepository.findByNumeroCuenta(numeroCuenta));
	}

	@Override
	public MovimientoDTO obtenerMovimiento(int id) {
		var response = movimientoRepository.findById(id);
        return response.map(MovimientoFactory::buildMovimientoDTO).orElse(null);
    }

	@Override
	public void eliminarMovimiento(int id) {
		movimientoRepository.deleteById(id);
	}
}
