package com.matheus.apispring.domain.titular;

public record RequestUsuario(
		String usuario,
		String senha,
		String cpf_cnpj
) {
}
