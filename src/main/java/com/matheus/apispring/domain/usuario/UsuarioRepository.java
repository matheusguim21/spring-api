package com.matheus.apispring.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger> {
	Usuario findUsuarioByNomeusuario(String nomeUsuario);
	UserDetails findByNomeusuario(String nomeUsuario);
	boolean existsUsuarioByNomeusuario(String nomeUsuario);
}
