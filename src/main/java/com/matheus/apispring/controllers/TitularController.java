package com.matheus.apispring.controllers;


import com.matheus.apispring.dtos.TitularDTO;
import com.matheus.apispring.dtos.UsuarioDTO;
import com.matheus.apispring.domain.titular.Titular;
import com.matheus.apispring.domain.titular.TitularRepository;
import com.matheus.apispring.services.TitularService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@RequestMapping("/titular")
public class TitularController {

	@Autowired
	private TitularService service;
	@Autowired
	private TitularRepository repository;

	@GetMapping("/titular")

	public ResponseEntity listarTitulares(){
		try{
			var titulares = repository.findAll();
			return ResponseEntity.ok(titulares);
		}catch (Exception error){
			return ResponseEntity.badRequest().body(error.getMessage());
		}
	}

	@PostMapping("/titular")
	public ResponseEntity criarTitular(@RequestBody @Valid TitularDTO data){
		try{
			Titular novoTitular = new Titular(data);
			repository.save(novoTitular);
			return ResponseEntity.status(201).body("Titular cadastrado com " +
					"sucesso");
		}catch (Exception error){
			return ResponseEntity.badRequest().body(error.getMessage());
		}
	}

	@PostMapping("/usuario")
	public ResponseEntity criarUsuario(@RequestBody @Valid UsuarioDTO data){

		try{
			service.criarUsuario(data);
			return ResponseEntity.status(201).body("Usuário criado com " +
					"sucesso");

		}catch (Exception error){
			return ResponseEntity.badRequest().body(error.getMessage());
		}

	}

	@DeleteMapping("/usuario")
	public ResponseEntity deletarUsuario(@RequestBody @Valid UsuarioDTO data){
		try{
			var titular = repository.findTitularByUsuario(data.usuario());
			if (titular != null){
				titular.setUsuario(null);
				titular.setSenha(null);
				repository.save(titular);
				return ResponseEntity.ok().body("Usuário exclúido com sucesso");
			}else {
				return ResponseEntity.badRequest().body("Usuário não " +
						"encontrado");
			}

		}catch (Exception error){
			return ResponseEntity.badRequest().body(error.getMessage());
		}

	};


}
