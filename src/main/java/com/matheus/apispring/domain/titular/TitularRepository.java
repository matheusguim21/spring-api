package com.matheus.apispring.domain.titular;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface TitularRepository extends JpaRepository<Titular, BigInteger> {
	Titular findTitularByCpf_cnpj(String cpf);
}
