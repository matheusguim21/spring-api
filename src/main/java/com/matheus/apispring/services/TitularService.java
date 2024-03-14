package com.matheus.apispring.services;

import com.matheus.apispring.domain.titular.Titular;
import com.matheus.apispring.domain.titular.TitularRepository;
import com.matheus.apispring.domain.usuario.Usuario;
import com.matheus.apispring.domain.usuario.UsuarioRepository;
import com.matheus.apispring.dtos.TitularDTO;
import com.matheus.apispring.dtos.UsuarioDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitularService {
	@Autowired
	private TitularRepository titularRepository ;
	@Autowired
	private UsuarioRepository usuarioRepository;


	public List<Titular> buscarTitulares(){

		return titularRepository.findAll();

	}


	public void criarTitular(TitularDTO titularDTO) throws  Exception{

			if(titularRepository.existsTitularByCpfcnpj(titularDTO.cpfcnpj())){
				throw new  Exception("Titular já existe");
			}
			Titular novoTitular = new Titular(titularDTO);
			titularRepository.save(novoTitular);


	}
	public void alterarSaldo(String cpf_cnpj) throws Exception {
		if(titularRepository.existsTitularByCpfcnpj(cpf_cnpj)){
			throw  new Exception("Titular não existe");
		}
		Titular titular = titularRepository.findTitularByCpfcnpj(cpf_cnpj);

	}


}
