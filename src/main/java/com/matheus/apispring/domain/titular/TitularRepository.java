package com.matheus.apispring.domain.titular;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.Optional;

public interface TitularRepository extends JpaRepository<Titular, BigInteger> {

//	@Query("SELECT t FROM Titular t WHERE t.cpf_cnpj = :cpfCnpj")
//	Optional<Titular> findByCpfCnpj(@Param("cpfCnpj") String cpfCnpj);

	Titular findTitularByCpfcnpj(String cpf_cnpj);
	boolean existsTitularByCpfcnpj(String cpf_cnpj);

	Titular findTitularByCodigosocinpro(BigInteger cod_socinpro);




}
