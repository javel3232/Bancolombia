package com.Bancolombia.Bancolombia.modelo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movimientos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Movimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Double valor;
	@Column(name = "numero_de_cuenta")
	private String numeroCuenta;
	private String fecha;
	@Column(name = "clase_de_movimiento")
	private String claseMovimiento;

	private String sucursal;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "numero_de_cuenta", insertable = false, updatable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Cuenta cuenta;


}
