package com.Bancolombia.Bancolombia.Controlador;


import com.Bancolombia.Bancolombia.modelo.dto.MovimientoDTO;
import com.Bancolombia.Bancolombia.servicio.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimiento")
@CrossOrigin("*")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping("/movimientos")
    public ResponseEntity<MovimientoDTO> registrarMovimiento(@RequestBody MovimientoDTO movimiento) {
        MovimientoDTO movimientoRegistrado = movimientoService.registrarMovimiento(movimiento);
        return ResponseEntity.ok(movimientoRegistrado);
    }

    @GetMapping("/{id}")
    public MovimientoDTO obtenerMovimientoPorId(@PathVariable("id") int id) {
        return movimientoService.obtenerMovimiento(id);
    }

    @GetMapping("/movimientos")
    public ResponseEntity<?> listarMovimientos() {
        return ResponseEntity.ok(movimientoService.obtenerMovimientos());
    }



    @PutMapping
    public MovimientoDTO actualizarMovimiento(MovimientoDTO movimiento) {
        return movimientoService.actualizarMovimiento(movimiento);
    }

    @DeleteMapping("/{id}")
    public void eliminarMovimiento(@PathVariable("id") int id) {
        movimientoService.eliminarMovimiento(id);
    }

    @GetMapping
    public ResponseEntity<?> obtenerMovimientosPorCuenta(String numeroCuenta) {
        return ResponseEntity.ok(movimientoService.obtenerMovimientosPorCuenta(numeroCuenta));
    }
}
