package com.application.sistemaSkill.dtos;

import java.util.List;

public class UsuarioSkillRequestDTO {

	private Long idUsuario;
	private List<SkillNivelRequestDTO>skill;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public List<SkillNivelRequestDTO> getSkill() {
		return skill;
	}
	public void setSkill(List<SkillNivelRequestDTO> skill) {
		this.skill = skill;
	}
	
	
}
