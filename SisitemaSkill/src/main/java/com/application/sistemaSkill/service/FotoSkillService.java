package com.application.sistemaSkill.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.sistemaSkill.entity.FotoSkill;
import com.application.sistemaSkill.entity.FotoUsuario;
import com.application.sistemaSkill.entity.Skill;
import com.application.sistemaSkill.exceptions.FotoException;
import com.application.sistemaSkill.exceptions.ResourceExistsException;
import com.application.sistemaSkill.exceptions.ResourceNotFoundException;
import com.application.sistemaSkill.repository.FotoSkillRepository;
@Service
public class FotoSkillService {

	@Autowired
	private FotoSkillRepository repository;
	
	public FotoSkill buscarFoto(Long id ) {
		Optional<FotoSkill> foto= repository.findById(id);
		if(foto.isPresent()) {
			return foto.get();
		}
		throw new ResourceNotFoundException("Foto não encontrada");
	}
	public FotoSkill salvarFoto(Skill skill, MultipartFile file) {
		FotoSkill f;
		try {
			f = new FotoSkill(skill,file);
			return repository.save(f);
		} catch (IOException e) {
			throw new FotoException("Erro ao salvar a foto do usuario!");
			
		}
	}
}
