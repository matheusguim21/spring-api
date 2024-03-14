package com.matheus.apispring.domain.fonograma;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface FonogramaRepository extends JpaRepository<Fonograma, BigInteger> {
}
