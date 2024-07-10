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
import com.poliana.demoparkapi.DTO.UsuarioSenhaDto;
import com.poliana.demoparkapi.DTO.usuarioCreateDTO;
import com.poliana.demoparkapi.DTO.mapper.UsuarioMapper;
import com.poliana.demoparkapi.entities.Usuario;
import com.poliana.demoparkapi.service.UsuarioService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
	
	@Autowired
	private  UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioResponseDto> create( @Valid @RequestBody usuarioCreateDTO createDto){
		Usuario user = usuarioService.save(UsuarioMapper.toUsuario(createDto));
		return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponseDto> getById(@PathVariable Long id){
		Usuario user = usuarioService.buscarPorId(id);
		return ResponseEntity.ok(UsuarioMapper.toDto(user));		
	}
	

	@PatchMapping("/{id}")
	public ResponseEntity<Void>updatePassword(@PathVariable Long id, @Valid @RequestBody UsuarioSenhaDto dto){
		Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfirmaSenha());
		return ResponseEntity.noContent().build();		
	}
	
	
	@GetMapping
	public ResponseEntity<List<UsuarioResponseDto>> getAll(){
		List<Usuario>users = usuarioService.buscarTodos();
		return ResponseEntity.ok(UsuarioMapper.toListDto(users));		
	}
	
	

}
