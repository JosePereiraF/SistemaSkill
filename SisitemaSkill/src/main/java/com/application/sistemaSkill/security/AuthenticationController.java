package com.application.sistemaSkill.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.sistemaSkill.dtos.LoginRequestDTO;
import com.application.sistemaSkill.dtos.UserLoginResponseDTO;
import com.application.sistemaSkill.entity.Usuario;
import com.application.sistemaSkill.exceptions.LoginIncorretoException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	 @Autowired 
	    private AuthenticationManager authenticationManager;
	    @Autowired
	    private TokenService tokenService;
	    @PostMapping("/login")
	    public ResponseEntity<UserLoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO login) {
	        try {
	            var usernamePassword = new UsernamePasswordAuthenticationToken(login.getLogin(), login.getSenha());
	            var auth = this.authenticationManager.authenticate(usernamePassword);

	            var token = tokenService.gerarToken((Usuario)auth.getPrincipal());

	            return ResponseEntity.ok(new UserLoginResponseDTO(token, (Usuario)auth.getPrincipal()));
	        } catch (BadCredentialsException e) {
	           throw new LoginIncorretoException();
	            
	        }
	    }
}
