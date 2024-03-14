package com.matheus.apispring.domain.obra;

import com.matheus.apispring.domain.titular.Titular;
import com.matheus.apispring.dtos.ObraDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger codigo_ecad;
	@NotNull
	private String titulo;
	@ManyToOne
	@JoinColumn(name = "titular_id")
	private Titular titular;

	public Obra(ObraDTO obraDTO, Titular titular){
		this.titulo = obraDTO.titulo();
		this.titular = titular;
	}
}
