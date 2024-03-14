package com.matheus.apispring.dtos;

import javax.annotation.Nullable;
import java.math.BigInteger;

public record TitularDTO(
	BigInteger id,
	String nome,
	String cpfcnpj,
	String pseudonimo,

	@Nullable
	String usuario,
	@Nullable
	String senha,
	@Nullable
	Double saldo,
	@Nullable
	String foto_perfil
){

}

