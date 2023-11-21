package com.matheus.apispring.domain.product.Endereco;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "endereco")
@Entity(name = "endereco")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Endereco {
	@Id
	private String id ;
	private  String logradouro ;
	private String numero;
	private  String bairro;
	private String cidade;
	private String estado;
	private String cep;

	public Endereco(RequestEndereco requestEndereco){
		this.bairro = requestEndereco.bairro();
		this.cep = requestEndereco.cep();
		this.id = requestEndereco.id();
		this.logradouro = requestEndereco.logradouro();
		this.cidade = requestEndereco.cidade();
		this.numero = requestEndereco.numero();
		this.estado = requestEndereco.estado();

	}


}

