package com.poliana.demoparkapi.DTO;

public class UsuarioSenhaDto {

	private String novaSenha;
	private String senhaAtual;
	private String confirmaSenha;
	
	public UsuarioSenhaDto() {
		super();
	}

	public UsuarioSenhaDto(String novaSenha, String senhaAtual, String confirmaSenha) {
		super();
		this.novaSenha = novaSenha;
		this.senhaAtual = senhaAtual;
		this.confirmaSenha = confirmaSenha;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	
	
	
	

}
