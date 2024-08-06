package com.application.sistemaSkill.dtos;

import com.application.sistemaSkill.entity.Skill;
import com.application.sistemaSkill.entity.UsuarioSkill;

public class SkillResponseDTO {
	private String foto;
	private String nome;
	private String descricao;
	
	public SkillResponseDTO() {
	}
	public SkillResponseDTO(Skill i) {
		this.foto = i.getUrl();
		this.nome=i.getNome();
		this.descricao=i.getDescricao();
	}
	public SkillResponseDTO(UsuarioSkill i) {
		this.foto = i.getId().getSkill().getUrl();
		this.nome= i.getId().getSkill().getNome();
		this.descricao = i.getId().getSkill().getDescricao();
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
