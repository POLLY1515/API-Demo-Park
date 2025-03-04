package com.poliana.demoparkapi.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poliana.demoparkapi.entities.Usuario;
import com.poliana.demoparkapi.exception.EntityNotFoundException;
import com.poliana.demoparkapi.exception.UsernameUniqueViolationException;
import com.poliana.demoparkapi.repository.UsuarioRepository;



@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public Usuario save(Usuario usuario) {
		try {
			return usuarioRepository.save(usuario);

		}catch(org.springframework.dao.DataIntegrityViolationException ex) {
			throw new UsernameUniqueViolationException(String.format("UserName {%s} ja cadastrado",
					usuario.getUserName()));
		}
		
	}

	@Transactional(readOnly = true)
	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id).orElseThrow(
				()-> new RuntimeException("Usuário não encontrado"));
	}

	@Transactional
	public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
		if(!novaSenha.equals(confirmaSenha)) {
			throw new EntityNotFoundException(String.format("Usuario id=%s não encontrado", id));
		}
		Usuario user = buscarPorId(id);
		
		if(!user.getPassword().equals(senhaAtual)) {
			throw new RuntimeException("Sua senha não confere");

		}
		user.setPassword(novaSenha);
		return user;
	}


	@Transactional(readOnly = true)
	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}

}
