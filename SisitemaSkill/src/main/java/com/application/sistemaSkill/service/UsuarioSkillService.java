package com.application.sistemaSkill.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.sistemaSkill.dtos.AtualizarSkillRequestDTO;
import com.application.sistemaSkill.dtos.ExcluirUsuarioSkillDTO;
import com.application.sistemaSkill.dtos.UsuarioSkillRequestDTO;
import com.application.sistemaSkill.dtos.UsuarioSkillResponseDTO;
import com.application.sistemaSkill.entity.Skill;
import com.application.sistemaSkill.entity.Usuario;
import com.application.sistemaSkill.entity.UsuarioSkill;
import com.application.sistemaSkill.entity.UsuarioSkillId;
import com.application.sistemaSkill.exceptions.ResourceNotFoundException;
import com.application.sistemaSkill.repository.SkillRepository;
import com.application.sistemaSkill.repository.UsuarioRepository;
import com.application.sistemaSkill.repository.UsuarioSkillRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioSkillService {

	@Autowired
	private UsuarioSkillRepository repository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private SkillRepository skillRepository;
	
	public List<UsuarioSkillResponseDTO> listarSkillUsuario(Long id) {
		Optional<Usuario>u =usuarioRepository.findById(id);
		if(u.isPresent()) {
			return u.get().getSkills().stream().map(i -> new UsuarioSkillResponseDTO(i)).collect(Collectors.toList());
		}
		throw new ResourceNotFoundException("Usuario não existente!");
	}
	@Transactional
	public List<UsuarioSkillResponseDTO> salvarSKills(UsuarioSkillRequestDTO usuarioSkill) {
			Optional<Usuario>usuario= usuarioRepository.findById(usuarioSkill.getIdUsario());
			if(usuario.isPresent()) {
				Set<UsuarioSkill> skills = new HashSet<>();
				usuarioSkill.getSkill().forEach(i->{
					Optional<Skill> skill =skillRepository.findById(i.getId());
					if(skill.isPresent()) {
						UsuarioSkill us = new UsuarioSkill(usuario.get(),skill.get(),i.getNivel());
						skills.add(us);
					}
				});
				usuario.get().setSkills(skills);
				Usuario usuarioSave =usuarioRepository.save(usuario.get());
				return usuarioSave.getSkills().stream().map(i-> new UsuarioSkillResponseDTO(i)).collect(Collectors.toList());
			}
			throw new ResourceNotFoundException("Usuario não encontrado!");
	}
	public UsuarioSkillResponseDTO atualizarSkill(AtualizarSkillRequestDTO a) {
		Optional <UsuarioSkill> us =repository.buscarUsuarioSkill(a.getIdUsuario(), a.getIdSkill());
		if(us.isPresent()) {
			
			return new UsuarioSkillResponseDTO(repository.save(new UsuarioSkill(us.get(),a)));
		}
		throw new ResourceNotFoundException("Recurso não encontrado!");
	}
	@Transactional
	public String excluirUsuarioSkill(ExcluirUsuarioSkillDTO e) {
		Optional <UsuarioSkill> us =repository.buscarUsuarioSkill(e.getIdUsuario(), e.getIdSkill());
		if(us.isPresent()) {
			repository.deletarUsuarioSkill(e.getIdUsuario(), e.getIdSkill());
			return "Skill excluida com sucesso.";
		}
		throw new ResourceNotFoundException("Recurso não encontrado!");
	}
}
