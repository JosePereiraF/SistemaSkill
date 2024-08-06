package com.application.sistemaSkill.dtos;

import java.util.List;

public class UsuarioSkillRequestDTO {

	private Long idUsario;
	private List<SkillNivelRequestDTO>skill;
	
	public Long getIdUsario() {
		return idUsario;
	}
	public void setIdUsario(Long idUsario) {
		this.idUsario = idUsario;
	}
	public List<SkillNivelRequestDTO> getSkill() {
		return skill;
	}
	public void setSkill(List<SkillNivelRequestDTO> skill) {
		this.skill = skill;
	}
	
	
}
