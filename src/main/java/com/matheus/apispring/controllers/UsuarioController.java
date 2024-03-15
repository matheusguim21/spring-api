package com.matheus.apispring.controllers;

import com.matheus.apispring.domain.usuario.Usuario;
import com.matheus.apispring.domain.usuario.UsuarioRepository;
import com.matheus.apispring.dtos.UsuarioDTO;
import com.matheus.apispring.services.UsuarioService;
import jakarta.validation.Valid;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private UsuarioService service;

	@GetMapping("usuarios")
	public ResponseEntity listarUsuarios(){
		try{
			var titulares = service.listarUsuarios();
			return ResponseEntity.ok(titulares);
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
			service.excluirUsuario(data);
			return ResponseEntity.ok().body("Usuário exclúido com sucesso");


		}catch (Exception error){
			return ResponseEntity.badRequest().body(error.getMessage());
		}

	};

	@PostMapping("/login")
	public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuarioDTO data){
		try{
			Usuario usuario= service.autenticarUsuario(data);
			if(usuario.isEnabled()) return ResponseEntity.ok().body( usuario);
			else return ResponseEntity.badRequest().body("Usuário ou senha " +
					"inválidos");

		}catch (Exception error){

			System.out.println(error.getClass());
			return ResponseEntity.badRequest().body(error.getMessage());
		}
	};

}
