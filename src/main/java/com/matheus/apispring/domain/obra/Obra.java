package com.matheus.apispring.domain.obra;

import com.matheus.apispring.domain.titular.Titular;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity(name = "Obra")
@Table(name = "obra")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Obra {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private BigInteger codigo_ecad;

	@ManyToOne
	@JoinColumn(name = "titular_id")
	private Titular titular;
}
