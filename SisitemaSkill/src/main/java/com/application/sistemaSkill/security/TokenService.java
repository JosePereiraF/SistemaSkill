package com.application.sistemaSkill.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.application.sistemaSkill.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class TokenService {
	@Value("${api.security.token.secrect}")
	private String chave;
	
	public String gerarToken(Usuario usuario) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(chave);
			String token = JWT.create()
					.withIssuer("login-sistemaSkill-api")
					.withSubject(usuario.getLogin())
					.withExpiresAt(this.expiracaoToken())
					.sign(algorithm);
			System.out.println("Login:"+usuario.getLogin());
			return token;
			
		} catch (JWTCreationException e) {
			throw new RuntimeException("Erro na autenticação do token");
		}
	}
	public String validadeToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(chave);
			return JWT.require(algorithm)
					.withIssuer("login-sistemaSkill-api")
					.build()
					.verify(token)
					.getSubject();
			
					
		} catch (JWTVerificationException e) {
			return "";
		}
	}
	private Instant expiracaoToken() {
		return LocalDateTime.now().plusHours(30).toInstant(ZoneOffset.of("-03:00"));
	}
}
