package com.application.sistemaSkill.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.sistemaSkill.dtos.UsuarioRequestDTO;
import com.application.sistemaSkill.dtos.UsuarioResponseDTO;
import com.application.sistemaSkill.entity.Usuario;
import com.application.sistemaSkill.exceptions.ResourceExistsException;
import com.application.sistemaSkill.exceptions.ResourceNotFoundException;
import com.application.sistemaSkill.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	
	public List<UsuarioResponseDTO> listarUsuario(){
		return repository.findAll().stream().map(i-> new UsuarioResponseDTO(i)).collect(Collectors.toList());
	}
	public UsuarioResponseDTO buscarUsuario(Long id) {
		Optional<Usuario>usuario= repository.findById(id);
		if(usuario.isPresent()) {
			return new UsuarioResponseDTO(usuario.get());
		}
		throw new ResourceNotFoundException("Usuario não encontrado");
	}
	public UsuarioResponseDTO salvarUsuario(UsuarioRequestDTO usuario, MultipartFile file) {
		if(repository.findByLogin(usuario.getLogin()).isPresent()) throw new ResourceExistsException("Login ja Existente!");
		Usuario u = new Usuario(usuario);
		u.setSenha(encoder.encode(usuario.getSenha()));
		repository.save(u);
		return new UsuarioResponseDTO(repository.save(u));
	}
	public UsuarioResponseDTO salvarUsuarioTeste(UsuarioRequestDTO usuario) {
		if(repository.findByLogin(usuario.getLogin()).isPresent()) throw new ResourceExistsException("Login ja Existente!");
		Usuario u = new Usuario(usuario);
		u.setSenha(encoder.encode(usuario.getSenha()));
		return new UsuarioResponseDTO(repository.save(u));
		
	}
	
}
