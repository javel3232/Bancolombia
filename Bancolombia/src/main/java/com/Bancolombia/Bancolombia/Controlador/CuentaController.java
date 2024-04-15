package com.Bancolombia.Bancolombia.Controlador;

import com.Bancolombia.Bancolombia.modelo.dto.CuentaDTO;
import com.Bancolombia.Bancolombia.modelo.entity.Cuenta;
import com.Bancolombia.Bancolombia.modelo.dto.MovimientoDTO;
import com.Bancolombia.Bancolombia.servicio.CuentaService;
import com.Bancolombia.Bancolombia.servicio.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cuenta")
@CrossOrigin(origins="http://localhost:4200")
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;

	@Autowired
	private MovimientoService movimientoService;

	@PostMapping("/cuentas")
	public ResponseEntity<CuentaDTO> registrarCuenta(@RequestBody CuentaDTO cuenta) {
		CuentaDTO cuentaRegistrada = cuentaService.registrarCuenta(cuenta);
		return ResponseEntity.ok(cuentaRegistrada);
	}

	@GetMapping("cuentas/{numeroCuenta}")
	public CuentaDTO listarCuentaPorId(@PathVariable("numeroCuenta") String numeroCuenta) {
		return cuentaService.obtenerCuenta(numeroCuenta);
	}

	@GetMapping("/cuentas")
	public ResponseEntity<?> listarCuentas() {
		return ResponseEntity.ok(cuentaService.obtenerCuentas());
	}

	@PutMapping("/{numeroCuenta}")
	public CuentaDTO actualizarCuenta(@RequestBody CuentaDTO cuenta) {

		return cuentaService.actualizarCuenta(cuenta);
	}

	@DeleteMapping("cuentas/{numeroCuenta}")
	public void eliminarCuenta(@PathVariable("numeroCuenta") String numeroCuenta) {
		cuentaService.eliminarCuenta(numeroCuenta);
	}

	@GetMapping("cuentas/{numeroCuenta}/movimientos")
	public Set<MovimientoDTO> obtenerMovimientosPorCuenta(@PathVariable String numeroCuenta) {
		return movimientoService.obtenerMovimientosPorCuenta(numeroCuenta);
	}

}
