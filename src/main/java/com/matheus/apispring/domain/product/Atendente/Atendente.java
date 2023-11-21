	package com.matheus.apispring.domain.product.Atendente;


	import com.matheus.apispring.domain.product.Consultorio.Consultorio;
	import jakarta.persistence.*;
	import lombok.*;

	@Entity(name = "atendente")
	@Table(name = "atendente")
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(of = "id")

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
