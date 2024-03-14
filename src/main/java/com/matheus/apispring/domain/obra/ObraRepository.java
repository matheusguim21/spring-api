package com.matheus.apispring.domain.obra;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;

public interface ObraRepository extends JpaRepository<Obra, BigInteger> {

	List<Obra> findObraByTitular_Codigosocinpro(BigInteger codigoSocinpro);
}
