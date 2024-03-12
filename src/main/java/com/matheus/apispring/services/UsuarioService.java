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

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {
	@Autowired
	private TitularRepository titularRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	public void criarUsuario(UsuarioDTO usuario){
		Optional<Titular> titular =
				titularRepository.findByCpfCnpj(usuario.cpf_cnpj());

		if(titular.isPresent()){
			BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
			String senhaCriptografada = crypt.encode(usuario.senha());
			Usuario novoUsuario = new Usuario(usuario, titular.get());
			novoUsuario.setSenha(senhaCriptografada);
			usuarioRepository.save(novoUsuario);

		}else{
			throw new EntityNotFoundException("Forneça um titular existente");
		}


	}
	public List<Usuario> listarUsuários(){
		return usuarioRepository.findAll();
	}
	public boolean autenticarUsuario(UsuarioDTO usuarioDTO){
		Optional<Usuario> usuario =
				usuarioRepository.findUsuarioByNome_Usuario(usuarioDTO.usuario());
		BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
		if(usuario.isPresent()) {

			return crypt.matches(usuarioDTO.senha(), usuario.get().getSenha());

		}
		return false;
	};

	public void  excluirUsuario(UsuarioDTO usuarioDTO){

			Optional<Usuario> usuario =
				usuarioRepository.findUsuarioByNome_Usuario(usuarioDTO.usuario());

			boolean autenticado = autenticarUsuario(usuarioDTO);

			if(autenticado) usuarioRepository.deleteById(usuario.get().getId());
		}



	}