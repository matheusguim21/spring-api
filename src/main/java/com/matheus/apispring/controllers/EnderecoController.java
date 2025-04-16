package com.matheus.apispring.controllers;

import com.matheus.apispring.domain.product.Endereco.Endereco;
import com.matheus.apispring.domain.product.Endereco.EnderecoRepository;
import com.matheus.apispring.domain.product.Endereco.RequestEndereco;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController{
	@Autowired
	private EnderecoRepository repository;
	@GetMapping
	public ResponseEntity getEndereco(){
		var allEnderecos = repository.findAll();
		return ResponseEntity.ok(allEnderecos);
	};
	@PostMapping
	public ResponseEntity createEndereco(@RequestBody @Valid RequestEndereco data){
		Optional<Endereco> enderecoExists = repository.findById(data.id());
		if(enderecoExists.isEmpty()) {
			Endereco endereco = new Endereco(data);
			var enderecoCridao = repository.save(endereco);
			System.out.println(data);
			return ResponseEntity.ok("Endereço criado com sucesso");
		}
		return ResponseEntity.badRequest().build();
	}
	@PutMapping
	public ResponseEntity changeEndereco(@RequestBody @Valid RequestEndereco data){
		Optional<Endereco> endereco = repository.findById(data.id());
		if (!endereco.isEmpty()) {
			Endereco novoEndereco = new Endereco(data);
			var enderecoAlterado = repository.save(novoEndereco);
			return ResponseEntity.ok(enderecoAlterado);
		}
		return ResponseEntity.noContent().build();
	}
}