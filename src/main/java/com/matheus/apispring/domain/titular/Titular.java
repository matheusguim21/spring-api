package com.matheus.apispring.domain.titular;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.math.BigInteger;

@Entity(name = "Titular")
@Table(name = "titular")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Titular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;
	private String nome;
	private String cpf_cnpj;
	@Nullable
	private String usuario;
	@Nullable
	private String senha;
	@Nullable
	private Double saldo;
	@Nullable
	private String foto_perfil;

	public Titular(RequestTitular requestTitular){
		this.cpf_cnpj = requestTitular.cpf_cnpj();
		this.foto_perfil = requestTitular.foto_perfil();
		this.id = requestTitular.id();
		this.nome = requestTitular.nome();
		this.usuario = requestTitular.usuario();
		this.senha = requestTitular.senha();;
		this.saldo = requestTitular.saldo();
	}

}
