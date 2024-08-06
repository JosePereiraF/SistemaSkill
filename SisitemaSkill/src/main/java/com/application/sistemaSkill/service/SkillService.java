package com.application.sistemaSkill.service;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.application.sistemaSkill.dtos.SkillRequestDTO;
import com.application.sistemaSkill.dtos.SkillResponseDTO;
import com.application.sistemaSkill.entity.Skill;
import com.application.sistemaSkill.exceptions.ResourceExistsException;
import com.application.sistemaSkill.exceptions.ResourceNotFoundException;
import com.application.sistemaSkill.repository.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository repository;
	@Autowired
	private FotoSkillService fotoSkillService;
	
	public List<SkillResponseDTO> listarSkill(){
		return repository.findAll().stream().map(i-> new SkillResponseDTO(i)).collect(Collectors.toList());
	}
	public SkillResponseDTO salvarSkill(SkillRequestDTO skill, MultipartFile file) {
		if(repository.findByNome(skill.getNome()).isPresent()) throw new ResourceExistsException("Skill ja existente no banco de dados!");
		if(file != null && !file.isEmpty()) {
			Skill s = new Skill(skill);
			repository.save(s);
			fotoSkillService.salvarFoto(s, file);
			URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/skill/foto/{id}")
					.buildAndExpand(s.getId()).toUri();
			s.setUrl(uri.toString());
			return new SkillResponseDTO(repository.save(s));
		}
		throw new ResourceNotFoundException("Campo de foto não foi preenchido");
	}
}
