package com.matheus.apispring.domain.product.Atendimento;

import com.matheus.apispring.domain.product.Atendente.Atendente;
import com.matheus.apispring.domain.product.Paciente.Paciente;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity(name = "atendimento")
@Table(name = "atendimento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")


public class Atendimento {
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private Date data;
	@ManyToOne @JoinColumn(name = "atendente_id")
	private Atendente atendente;
	@ManyToOne @JoinColumn(name = "paciente_id")
	private Paciente paciente;
}
