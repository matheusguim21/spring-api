package com.matheus.apispring.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger> {
	@Query("SELECT u FROM Usuario u WHERE u.usuario = :nome_usuario")
	Optional<Usuario> findUsuarioByNome_Usuario(@Param("nome_usuario") String nome_usuario);
	UserDetails findByUsuario(String login);
}
