package com.matheus.apispring.services;

import com.matheus.apispring.domain.titular.Titular;
import com.matheus.apispring.domain.titular.TitularRepository;
import com.matheus.apispring.dtos.TitularDTO;
import com.matheus.apispring.dtos.UsuarioDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TitularService {
	@Autowired
	private TitularRepository repository ;

	public void criarUsuario(UsuarioDTO usuario){
		Optional<Titular> titular =
				repository.findByCpfCnpj(usuario.cpf_cnpj());

		if(titular.isPresent()){
			titular.get().setUsuario(usuario.usuario());
			BCryptPasswordEncoder criptografar = new BCryptPasswordEncoder();
			String senhaCriptografada = criptografar.encode(usuario.senha());
			titular.get().setSenha(senhaCriptografada);
		}else{
			throw new EntityNotFoundException();
		}


	}
}
