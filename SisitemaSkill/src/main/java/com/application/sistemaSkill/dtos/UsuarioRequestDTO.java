package com.application.sistemaSkill.dtos;

import jakarta.validation.constraints.NotBlank;

public class UsuarioRequestDTO {
	@NotBlank(message = "O nome não pode ser vazio!")
	private String nome;
	@NotBlank(message = "O login não pode ser vazio!")
	private String login;
	@NotBlank(message = "A senha não pode ser vazia!")
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
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
	
	
}
