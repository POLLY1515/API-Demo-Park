package com.poliana.demoparkapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poliana.demoparkapi.entities.Usuario;
import com.poliana.demoparkapi.repository.UsuarioRepository;



@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Transactional(readOnly = true)
	public Usuario buscarPorId(Long id) {
		return usuarioRepository.findById(id).orElseThrow(
				()-> new RuntimeException("Usuário não encontrado"));
	}

	@Transactional
	public Usuario editarSenha(Long id, String password) {
		Usuario user = buscarPorId(id);
		user.setPassword(password);
		return user;
	}


	@Transactional(readOnly = true)
	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}

}
