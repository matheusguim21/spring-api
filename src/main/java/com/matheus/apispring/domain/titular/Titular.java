package com.matheus.apispring.domain.titular;

import com.matheus.apispring.dtos.TitularDTO;
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

	public Titular(TitularDTO titularDTO){
		this.cpf_cnpj = titularDTO.cpf_cnpj();
		this.foto_perfil = titularDTO.foto_perfil();
		this.id = titularDTO.id();
		this.nome = titularDTO.nome();
		this.usuario = titularDTO.usuario();
		this.senha = titularDTO.senha();;
		this.saldo = titularDTO.saldo();
	}

}
