package com.matheus.apispring.controllers;

import com.matheus.apispring.domain.obra.Obra;
import com.matheus.apispring.domain.obra.ObraRepository;
import com.matheus.apispring.dtos.ObraDTO;
import com.matheus.apispring.services.ObraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/obra")
public class ObraController {
	@Autowired
	private ObraService service ;

	private ObraRepository repository;
	@GetMapping("/obras")
	public ResponseEntity buscarObras(){
		try{
			var obras = service.buscarObras();
			return ResponseEntity.ok(obras);
		}catch (Exception exception){
			return ResponseEntity.badRequest().body(exception.getMessage());
		}
	}

	@PostMapping("/obra")
	public ResponseEntity criarObra(@RequestBody @Valid ObraDTO data){
		try{
			service.criarObra(data);
			return ResponseEntity.accepted().body("Obra cadastrada com " +
					"sucesso");
		}catch (Exception exception){
			return ResponseEntity.badRequest().body(exception.getMessage());
		}

	}
	@GetMapping("/obrastitular")
	public ResponseEntity buscarObrasDoTitular(@RequestParam  BigInteger codigosocinpro){
		try{


			System.out.println(codigosocinpro.getClass());
			var obras = service.buscarObraPorTitular(codigosocinpro);
			return  ResponseEntity.ok(obras);

		}catch (Exception exception){
			return ResponseEntity.badRequest().body(exception.getMessage());
		}
	}

}
