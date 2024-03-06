package com.matheus.apispring.controllers;


import com.matheus.apispring.domain.titular.RequestTitular;
import com.matheus.apispring.domain.titular.RequestUsuario;
import com.matheus.apispring.domain.titular.Titular;
import com.matheus.apispring.domain.titular.TitularRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@RequestMapping("/titular")
public class TitularController {
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

	@PostMapping("/usuario")
	public ResponseEntity criarUsuario(@RequestBody @Valid RequestUsuario data){
		try{
			Titular titular =
					repository.findByCpfCnpj(data.cpf_cnpj());

			if(titular != null){
				if (titular.getUsuario() == null) {
					titular.setUsuario(data.usuario());
					titular.setSenha(data.senha());
					repository.save(titular);
					return (ResponseEntity) ResponseEntity.ok("Usuário criado com" +
							" sucesso");
				}else {
					return ResponseEntity.badRequest().body("já existe um " +
							"usuário criado para esse titular");
				}

			}
			else {
				return ResponseEntity.badRequest().body("Dados do titular " +
						"inválidos");
			}
		}catch (Exception error){
			return ResponseEntity.badRequest().body(error.getMessage());
		}

	}

	@DeleteMapping("/usuario")
	public ResponseEntity deletarUsuario(@RequestBody @Valid RequestUsuario data){
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
