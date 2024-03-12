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



}
