package com.matheus.apispring.controllers;


import com.matheus.apispring.domain.titular.RequestTitular;
import com.matheus.apispring.domain.titular.RequestUsuario;
import com.matheus.apispring.domain.titular.Titular;
import com.matheus.apispring.domain.titular.TitularRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/titular")
public class TitularController {
	@Autowired
	private TitularRepository repository;

	@GetMapping

	public ResponseEntity listarTitulares(){
		try{
			var titulares = repository.findAll();
			return ResponseEntity.ok(titulares);
		}catch (Exception error){
			return ResponseEntity.badRequest().body(error.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity criarTitular(@RequestBody @Valid RequestTitular data){
		try{
			Titular novoTitular = new Titular(data);
			repository.save(novoTitular);
			return ResponseEntity.status(201).body("Titular cadastrado com " +
					"sucesso");
		}catch (Exception error){
			return ResponseEntity.badRequest().body(error.getMessage());
		}
	}

	public ResponseEntity criarUsuario(@RequestBody @Valid RequestUsuario data){
		try{
			var titular = repository.findTitularByCpf_cnpj(data.cpf_cnpj());
			if(titular.equals(data.cpf_cnpj())){
				titular.setUsuario(data.usuario());
				titular.setSenha(data.senha());
				repository.save(titular);
				return (ResponseEntity) ResponseEntity.ok();

			}
			else {
				return ResponseEntity.badRequest().body("Dados do titular " +
						"inválidos");
			}
		}catch (Exception error){
			return ResponseEntity.badRequest().body(error.getMessage());
		}

	}


}
