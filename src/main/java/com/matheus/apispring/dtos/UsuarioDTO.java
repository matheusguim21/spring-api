package com.matheus.apispring.dtos;

import java.math.BigInteger;

public record UsuarioDTO(
		BigInteger id,
		String nomeusuario,
		String senha,
		String cpfcnpj,

		String role


) {
}
