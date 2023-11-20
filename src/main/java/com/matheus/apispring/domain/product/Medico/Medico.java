package com.matheus.apispring.domain.product.Medico;

import com.matheus.apispring.domain.product.Atendimento.Atendimento;
import com.matheus.apispring.domain.product.Consultorio.Consultorio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Medico {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String nome;
	private String telefone;
	@ManyToMany @JoinColumn(name = "consultorio_id")
	private List<Consultorio> consultorios;
	@ManyToOne @JoinColumn(name = "atendimento_id")
	private Atendimento atendimento;

}
