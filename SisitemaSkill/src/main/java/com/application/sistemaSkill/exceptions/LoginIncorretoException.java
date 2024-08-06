package com.application.sistemaSkill.exceptions;

public class LoginIncorretoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public LoginIncorretoException() {
		super("Login ou senha incorreta!");
	}

}
