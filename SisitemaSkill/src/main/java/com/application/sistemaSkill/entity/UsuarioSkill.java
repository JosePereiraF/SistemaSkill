package com.application.sistemaSkill.entity;

import java.util.List;

import com.application.sistemaSkill.dtos.AtualizarSkillRequestDTO;
import com.application.sistemaSkill.enums.NivelENUM;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class UsuarioSkill {

	@EmbeddedId
	private UsuarioSkillId id = new UsuarioSkillId();
	private NivelENUM nivel;
	
	public UsuarioSkill() {
	}
	public UsuarioSkill(Usuario usuario, Skill skill, NivelENUM nivel) {
		this.id.setUsuario(usuario);
		this.id.setSkill(skill);
		this.nivel = nivel;
	}
	public UsuarioSkill(UsuarioSkill usuarioSkill, AtualizarSkillRequestDTO a) {
		this.id = usuarioSkill.getId();
		this.nivel = a.getNivel();
	}
	public UsuarioSkillId getId() {
		return id;
	}
	public void setId(UsuarioSkillId id) {
		this.id = id;
	}
	public NivelENUM getNivel() {
		return nivel;
	}
	public void setNivel(NivelENUM nivel) {
		this.nivel = nivel;
	}
	@Override
	public String toString() {
		return "UsuarioSkill [id=" + id + ", nivel=" + nivel + "]";
	}
	
}
