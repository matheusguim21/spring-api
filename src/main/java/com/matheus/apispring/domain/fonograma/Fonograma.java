package com.matheus.apispring.domain.fonograma;

import com.matheus.apispring.domain.titular.Titular;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigInteger;

@Entity(name = "Fonograma")
@Table(name = "fonograma")
@Data
public class Fonograma {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private BigInteger codigo_ecad;

	private String isrc;
	@NotNull
	private String titulo;
	@ManyToOne
	@JoinColumn(name = "titular_id") // Define o nome da coluna de chave estrangeira na tabela fonogramas
	private Titular titular;
}
