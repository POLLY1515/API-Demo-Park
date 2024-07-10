package com.poliana.demoparkapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poliana.demoparkapi.DTO.UsuarioResponseDto;
import com.poliana.demoparkapi.DTO.usuarioCreateDTO;
import com.poliana.demoparkapi.DTO.mapper.UsuarioMapper;
import com.poliana.demoparkapi.entities.Usuario;
import com.poliana.demoparkapi.service.UsuarioService;


@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
	
	@Autowired
	private  UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioResponseDto> create(@RequestBody usuarioCreateDTO createDto){
		Usuario user = usuarioService.save(UsuarioMapper.toUsuario(createDto));
		return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id){
		Usuario user = usuarioService.buscarPorId(id);
		return ResponseEntity.ok(user);		
	}
	

	@PatchMapping("/{id}")
	public ResponseEntity<Usuario> updatePassword(@PathVariable Long id ,@RequestBody Usuario usuario){
		Usuario user = usuarioService.editarSenha(id, usuario.getPassword());
		return ResponseEntity.ok(user);		
	}
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		List<Usuario>users = usuarioService.buscarTodos();
		return ResponseEntity.ok(users);		
	}
	
	

}
