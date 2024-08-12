package com.application.sistemaSkill.dtos;

public class ExcluirUsuarioSkillDTO {
	private Long idUsuario;
	private Long idSkill;
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
	@Override
	public String toString() {
		return "ExcluirUsuarioSkillDTO [idUsuario=" + idUsuario + ", idSkill=" + idSkill + "]";
	}
	
	
}
