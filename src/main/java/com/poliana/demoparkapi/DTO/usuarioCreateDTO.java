package com.poliana.demoparkapi.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class usuarioCreateDTO {
	
	@NotBlank
	@Email(message = "Formato do email inválido!")
	private String userName;
	
	@NotBlank
	@Size(min = 6, max = 6)
	private  String password;
	
	
	public usuarioCreateDTO() {
		super();
	}
	
	public usuarioCreateDTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
