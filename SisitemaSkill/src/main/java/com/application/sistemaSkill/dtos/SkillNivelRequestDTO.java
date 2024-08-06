package com.application.sistemaSkill.dtos;

import com.application.sistemaSkill.enums.NivelENUM;

public class SkillNivelRequestDTO {

	private Long id;
	private NivelENUM nivel;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public NivelENUM getNivel() {
		return nivel;
	}
	public void setNivel(NivelENUM nivel) {
		this.nivel = nivel;
	}

	
}
