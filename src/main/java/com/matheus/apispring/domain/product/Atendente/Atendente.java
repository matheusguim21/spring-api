	package com.matheus.apispring.domain.product.Atendente;


	import com.matheus.apispring.domain.product.Consultorio.Consultorio;
	import jakarta.persistence.*;
	import lombok.AllArgsConstructor;
	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;

	@Entity(name = "atendente")
	@Table(name = "atendente")
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor

	public class Atendente {
		@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Integer id;
		private String nome;
		private String cpf;
		@ManyToOne @JoinColumn(name = "consultorio_id")
		private Consultorio consultorio;
		private String usuario;
		private String senha;


	}
