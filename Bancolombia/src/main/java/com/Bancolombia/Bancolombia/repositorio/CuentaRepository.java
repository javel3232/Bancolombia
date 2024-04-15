package com.Bancolombia.Bancolombia.repositorio;

import com.Bancolombia.Bancolombia.modelo.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, String> {

    public Optional<Cuenta> findByNumeroCuenta(String numeroCuenta);
}
