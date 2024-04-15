package com.Bancolombia.Bancolombia.repositorio;

import com.Bancolombia.Bancolombia.modelo.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
    Set<Movimiento> findByNumeroCuenta(String numeroCuenta);
}
