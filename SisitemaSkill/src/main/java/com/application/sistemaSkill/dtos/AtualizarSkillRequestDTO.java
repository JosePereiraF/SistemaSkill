package com.application.sistemaSkill.dtos;

import com.application.sistemaSkill.enums.NivelENUM;

public class AtualizarSkillRequestDTO {
	private Long idUsuario;
	private Long idSkill;
	private NivelENUM nivel;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdSkill() {
		return idSkill;
	}
	public void setIdSkill(Long idSkill) {
		this.idSkill = idSkill;
	}
	public NivelENUM getNivel() {
		return nivel;
	}
	public void setNivel(NivelENUM nivel) {
		this.nivel = nivel;
	}
	
}
