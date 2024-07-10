package com.poliana.demoparkapi.DTO;


public class UsuarioResponseDto {
	
	private Long id;
	private String userName;
	private String role;
	
	public UsuarioResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioResponseDto(Long id, String userName, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	

	public void setRole(String role2) {
		// TODO Auto-generated method stub
		
	}
	
	

}
