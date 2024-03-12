package com.matheus.apispring.controllers;

import com.matheus.apispring.domain.usuario.Usuario;
import com.matheus.apispring.domain.usuario.UsuarioRepository;
import com.matheus.apispring.dtos.UsuarioDTO;
import com.matheus.apispring.services.UsuarioService;
import jakarta.validation.Valid;
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
			var titulares = service.listarUsuários();
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
			Optional<Usuario> usuario =
					repository.findUsuarioByNome_Usuario(data.usuario());
				if(usuario.isPresent()) {
					service.excluirUsuario(data);
					return ResponseEntity.ok().body("Usuário exclúido com sucesso");
				}
			else {
				return ResponseEntity.badRequest().body("Usuário não " +
						"encontrado");
			}

		}catch (Exception error){
			return ResponseEntity.badRequest().body(error.getMessage());
		}

	};

	@PostMapping("/login")
	public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuarioDTO data){
		try{
			boolean autenticado = service.autenticarUsuario(data);
			if(autenticado) return ResponseEntity.ok().body("usuário " +
					"autenticado");
			else return ResponseEntity.badRequest().body("Usuário ou senha " +
					"inválidos");

		}catch (Exception error){
			return ResponseEntity.badRequest().body(error.getMessage());
		}
	};

}
