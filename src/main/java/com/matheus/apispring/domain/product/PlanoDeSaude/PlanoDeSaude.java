package com.matheus.apispring.domain.product.PlanoDeSaude;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "planodesaude")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class PlanoDeSaude {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
}
