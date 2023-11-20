package com.matheus.apispring.domain.product.Consulta;

import com.matheus.apispring.domain.product.Atendente.Atendente;
import com.matheus.apispring.domain.product.Medico.Medico;
import com.matheus.apispring.domain.product.Paciente.Paciente;
import com.matheus.apispring.domain.product.PlanoDeSaude.PlanoDeSaude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

enum TipoDeConsulta{
	plano, particular
}
enum StatusConsulta{
	agendada, concluída, EmProgresso
}

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {
	@Id @GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private Date data;
	private Enum<TipoDeConsulta> tipo;
	private Enum<StatusConsulta> status;
	private String diagnostico;
	private  String receita;
	@ManyToOne
	@JoinColumn(name = "plano_de_saude_id")
	private PlanoDeSaude planoDeSaude;
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	@ManyToOne @JoinColumn(name = "atendente_id")
	private Atendente atendente;

	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;



}



