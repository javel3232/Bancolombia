package com.Bancolombia.Bancolombia.servicio.impl;

import com.Bancolombia.Bancolombia.modelo.dto.CuentaDTO;
import com.Bancolombia.Bancolombia.modelo.entity.Cuenta;
import com.Bancolombia.Bancolombia.modelo.factory.CuentaFactory;
import com.Bancolombia.Bancolombia.modelo.factory.MovimientoFactory;
import com.Bancolombia.Bancolombia.repositorio.CuentaRepository;
import com.Bancolombia.Bancolombia.servicio.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private CuentaRepository cuentaRepository;

	@Override
	public CuentaDTO registrarCuenta(CuentaDTO cuenta) {


		var response= cuentaRepository.save(CuentaFactory.buildCuentaEntity(cuenta));
		 return CuentaFactory.buildCuentaDTO(response);
	}

	@Override
	public CuentaDTO actualizarCuenta(CuentaDTO cuenta) {

		var response= cuentaRepository.save(CuentaFactory.buildCuentaEntity(cuenta));
		return CuentaFactory.buildCuentaDTO(response);
	}

	@Override
	public Set<CuentaDTO> obtenerCuentas() {
		return CuentaFactory.buildCuentasDTO(new LinkedHashSet<>(cuentaRepository.findAll()));
	}

	@Override
	public CuentaDTO obtenerCuenta(String numeroCuenta) {
		var response = cuentaRepository.findByNumeroCuenta(numeroCuenta);
		return response.map(CuentaFactory::buildCuentaDTO).orElse(null);
	}

	@Override
	public void eliminarCuenta(String numeroCuenta) {
		Cuenta cuenta = new Cuenta();
		cuenta.setNumeroCuenta(numeroCuenta);
		cuentaRepository.delete(cuenta);

	}
}
