package com.matheus.apispring.domain.product.Paciente;

import com.matheus.apispring.domain.product.Atendimento.Atendimento;
import com.matheus.apispring.domain.product.Consulta.Consulta;
import com.matheus.apispring.domain.product.Endereco.Endereco;
import com.matheus.apispring.domain.product.PlanoDeSaude.PlanoDeSaude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	@OneToOne @JoinColumn(name = "endereco_id")
	private Endereco endereco;
	private String telefone;
	private Date data_nascimento;
	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas;
	@ManyToOne @JoinColumn(name = "plano_de_saude_id")
	private PlanoDeSaude planoDeSaude;
	@OneToMany @JoinColumn(name = "atendimentos_id")
	private List<Atendimento> atendimentos;
}
