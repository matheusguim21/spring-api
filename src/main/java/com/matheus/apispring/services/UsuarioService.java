package com.matheus.apispring.services;

import com.matheus.apispring.domain.titular.Titular;
import com.matheus.apispring.domain.titular.TitularRepository;
import com.matheus.apispring.domain.usuario.Usuario;
import com.matheus.apispring.domain.usuario.UsuarioRepository;
import com.matheus.apispring.dtos.UsuarioDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {
	@Autowired
	private TitularRepository titularRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;


	public void criarUsuario(UsuarioDTO usuario){


		if(titularRepository.existsTitularByCpfcnpj(usuario.cpfcnpj())){
		Titular titular =
				titularRepository.findTitularByCpfcnpj(usuario.cpfcnpj());

			BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
			String senhaCriptografada = crypt.encode(usuario.senha());
			Usuario novoUsuario = new Usuario(usuario, titular);
			novoUsuario.setSenha(senhaCriptografada);
			usuarioRepository.save(novoUsuario);
			System.out.println("Chegou aqui");
		}else{
			throw new EntityNotFoundException("Forneça um titular existente");
		}


	}
	public List<Usuario> listarUsuários(){
		return usuarioRepository.findAll();
	}
	public Usuario autenticarUsuario(UsuarioDTO usuarioDTO) throws AuthenticationException {

		BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
		if (usuarioRepository.existsUsuarioByNomeusuario(usuarioDTO.nomeusuario())) {
			Usuario usuario = usuarioRepository.findUsuarioByNomeusuario(usuarioDTO.nomeusuario());
			boolean autenticado = crypt.matches(usuarioDTO.senha(),
					usuario.getSenha());
			if (autenticado) return usuario;
		}
			throw new AuthenticationException("Usuário ou senha inválidos");

	};


	public void  excluirUsuario(UsuarioDTO usuarioDTO) throws Exception {
		if (usuarioRepository.existsUsuarioByNomeusuario(usuarioDTO.nomeusuario())) {
			Usuario usuario =
					usuarioRepository.findUsuarioByNomeusuario(usuarioDTO.nomeusuario());
			BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
			boolean autenticado = crypt.matches(usuarioDTO.senha(),
					usuario.getSenha());
			if (autenticado) usuarioRepository.deleteById(usuario.getId());

		}else{
			throw  new Exception("Usuário não existe");
		}
	}



	}
