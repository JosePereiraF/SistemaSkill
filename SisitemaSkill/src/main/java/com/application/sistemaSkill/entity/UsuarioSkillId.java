package com.application.sistemaSkill.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class UsuarioSkillId {

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "id_skill")
	private Skill skill;
	public UsuarioSkillId() {
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
	
}
