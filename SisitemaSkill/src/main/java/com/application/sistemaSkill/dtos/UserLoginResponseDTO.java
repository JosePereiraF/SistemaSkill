package com.application.sistemaSkill.dtos;

import com.application.sistemaSkill.entity.Usuario;

public class UserLoginResponseDTO {
	private String token;
	private UsuarioResponseDTO usuario;
	
	public UserLoginResponseDTO(String token, Usuario usuario) {
		this.token = token;
		this.usuario = new UsuarioResponseDTO(usuario);
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UsuarioResponseDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioResponseDTO usuario) {
		this.usuario = usuario;
	}
	
	
}
