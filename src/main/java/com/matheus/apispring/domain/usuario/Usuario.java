package com.matheus.apispring.domain.usuario;

import com.matheus.apispring.domain.titular.Titular;
import com.matheus.apispring.dtos.UsuarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

@Entity(name = "Usuario")
@Table(name =  "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario implements UserDetails {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigInteger id;

	private String usuario;
	private String senha;
	private UsuarioRole role;

	@OneToOne
	@JoinColumn(name = "titular_id")
	private Titular titular;

	public  Usuario(UsuarioDTO usuarioDTO, Titular titular){
		this.usuario = usuarioDTO.usuario();
		this.senha = usuarioDTO.senha();
		this.role = UsuarioRole.valueOf(usuarioDTO.role());
		this.titular = titular;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UsuarioRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),  new SimpleGrantedAuthority("ROLE_USER"));
		else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}

