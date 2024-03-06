package com.matheus.apispring.domain.titular;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.Optional;

public interface TitularRepository extends JpaRepository<Titular, BigInteger> {
	@Query("SELECT t FROM Titular t WHERE t.cpf_cnpj = :cpfCnpj")
	Titular findByCpfCnpj(@Param("cpfCnpj") String cpfCnpj);

	@Query("SELECT t FROM Titular t WHERE t.usuario = :usuario")
	Titular findTitularByUsuario(@Param("usuario") String usuario);



}
