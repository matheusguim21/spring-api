package com.matheus.apispring.services;

import com.matheus.apispring.domain.obra.Obra;
import com.matheus.apispring.domain.obra.ObraRepository;
import com.matheus.apispring.domain.titular.TitularRepository;
import com.matheus.apispring.dtos.ObraDTO;
import com.matheus.apispring.dtos.TitularDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ObraService {
	@Autowired
	private ObraRepository obraRepository;
	@Autowired
	private TitularRepository titularRepository;

	public List<Obra> buscarObras(){
		var obras = obraRepository.findAll();
		if(obras.isEmpty()){
			throw new EntityNotFoundException("Não existem obras ainda");
		}
		return obras;
	};

	public void criarObra(ObraDTO obraDTO) throws Exception {
		var titular =
				titularRepository.findTitularByCodigosocinpro(obraDTO.codigotitular());
		System.out.println(obraDTO.codigotitular());
		System.out.println(titular);

		if(titular == null){
			throw new Exception("Titular não encontrado");
		}
		Obra novaObra = new Obra(obraDTO, titular);

		obraRepository.save(novaObra);



	}

	public List<Obra> buscarObraPorTitular(BigInteger codigoSocinpro) throws Exception {
		var obras =
				obraRepository.findObraByTitular_Codigosocinpro(codigoSocinpro);
		if(obras.isEmpty()){
			throw new Exception("Nenhuma obra para esse titular ainda");
		}
		return obras;
	}
}
