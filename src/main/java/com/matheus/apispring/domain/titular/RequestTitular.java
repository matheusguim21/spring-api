package com.matheus.apispring.domain.titular;

import javax.annotation.Nullable;
import java.math.BigInteger;

public record RequestTitular(
	BigInteger id,
	String nome,
	String cpf_cnpj,
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

