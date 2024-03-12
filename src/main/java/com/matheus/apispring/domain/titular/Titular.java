package com.matheus.apispring.domain.titular;

import com.matheus.apispring.domain.usuario.Usuario;
import com.matheus.apispring.dtos.TitularDTO;
import com.matheus.apispring.dtos.UsuarioDTO;
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
	private Double saldo;
	@Nullable
	private String foto_perfil;

	public Titular(TitularDTO titularDTO){
		this.cpf_cnpj = titularDTO.cpf_cnpj();
		this.foto_perfil = titularDTO.foto_perfil();
		this.id = titularDTO.id();
		this.nome = titularDTO.nome();
		this.saldo = titularDTO.saldo();
	}

}
