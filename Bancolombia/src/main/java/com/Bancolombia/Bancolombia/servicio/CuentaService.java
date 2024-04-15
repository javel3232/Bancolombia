package com.Bancolombia.Bancolombia.servicio;

import com.Bancolombia.Bancolombia.modelo.dto.CuentaDTO;
import com.Bancolombia.Bancolombia.modelo.entity.Cuenta;

import java.util.Set;

public interface CuentaService {

	CuentaDTO registrarCuenta(CuentaDTO cuenta);

	CuentaDTO actualizarCuenta(CuentaDTO cuenta);

	Set<CuentaDTO> obtenerCuentas();

	CuentaDTO obtenerCuenta(String numeroCuenta);

	void eliminarCuenta(String numeroCuenta);
}
