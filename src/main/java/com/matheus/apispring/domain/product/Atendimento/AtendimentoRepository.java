package com.matheus.apispring.domain.product.Atendimento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AtendimentoRepository extends JpaRepository<Atendimento,
		UUID> {
}
