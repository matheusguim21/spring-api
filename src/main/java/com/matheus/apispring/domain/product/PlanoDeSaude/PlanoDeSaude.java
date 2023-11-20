package com.matheus.apispring.domain.product.PlanoDeSaude;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanoDeSaude {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
}
