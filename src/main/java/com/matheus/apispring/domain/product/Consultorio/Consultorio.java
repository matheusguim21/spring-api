package com.matheus.apispring.domain.product.Consultorio;

import com.matheus.apispring.domain.product.Endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "consultorio")
@Table(name = "consultorio")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor



public class Consultorio {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idConsultorio;
	private String nome;
	private Endereco endereco;

}
