package com.Bancolombia.Bancolombia.modelo.entity;

import jakarta.persistence.*;

import java.util.Set;

import lombok.*;

@Entity
@Table(name = "cuentas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Cuenta {

	@Id
	@Column(name = "numero_de_cuenta")
	private String numeroCuenta;

	@Column(name = "tipo_de_cuenta")
	private String tipoCuenta;

	private Double saldo;

	private String titular;
	private String documento;

	@OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
	//@JsonIgnore
	private Set<Movimiento> movimientos;

}