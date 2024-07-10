package com.poliana.demoparkapi.DTO.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.poliana.demoparkapi.DTO.UsuarioResponseDto;
import com.poliana.demoparkapi.DTO.usuarioCreateDTO;
import com.poliana.demoparkapi.entities.Usuario;

public class UsuarioMapper {

	public static Usuario toUsuario(usuarioCreateDTO createDto) {
		return new ModelMapper().map(createDto, Usuario.class);
	}
	
	
	public static UsuarioResponseDto toDto(Usuario usuario) {
		String role = usuario.getRole().name().substring("Role_".length());
		PropertyMap<Usuario, UsuarioResponseDto> props = new PropertyMap<Usuario, UsuarioResponseDto>() {

			@Override
			protected void configure() {
				map().setRole(role);
			}
		}; 
		     
		ModelMapper mapper =  new ModelMapper();
		mapper.addMappings(props);
		return mapper.map(usuario, UsuarioResponseDto.class);
	}
}
