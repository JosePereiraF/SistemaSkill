package com.application.sistemaSkill.dtos;

public class LoginRequestDTO {

	private String login;
	private String senha;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "LoginRequestDTO [login=" + login + ", senha=" + senha + "]";
	}
	
}
