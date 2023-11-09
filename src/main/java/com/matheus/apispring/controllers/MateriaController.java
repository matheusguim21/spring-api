	package com.matheus.apispring.controllers;

	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@RestController
	@RequestMapping("/materias")
	public class MateriaController {
		@GetMapping
		public ResponseEntity getAllMaterias(){
			return ResponseEntity.ok().body("Hello World");
		}


	}
