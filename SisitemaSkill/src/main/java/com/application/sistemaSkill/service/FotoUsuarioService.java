package com.application.sistemaSkill.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.sistemaSkill.entity.FotoUsuario;
import com.application.sistemaSkill.entity.Usuario;
import com.application.sistemaSkill.exceptions.FotoException;
import com.application.sistemaSkill.exceptions.ResourceNotFoundException;
import com.application.sistemaSkill.repository.FotoUsuarioRepository;

@Service
public class FotoUsuarioService {

	@Autowired
	private FotoUsuarioRepository repository;
	
	public FotoUsuario buscarFoto(Long id ) {
		Optional<FotoUsuario> foto= repository.findById(id);
		if(foto.isPresent()) {
			return foto.get();
		}
		throw new ResourceNotFoundException("Foto não encontrada");
	}
	public FotoUsuario salvarFoto(Usuario usuario, MultipartFile file) {
		FotoUsuario f;
		try {
			f = new FotoUsuario(usuario,file);
			return repository.save(f);
		} catch (IOException e) {
			throw new FotoException("Erro ao salvar a foto do usuario!");
			
		}
	}
}
