package com.application.sistemaSkill.dtos;

import com.application.sistemaSkill.entity.Skill;
import com.application.sistemaSkill.entity.UsuarioSkill;
import com.application.sistemaSkill.enums.NivelENUM;

public class SkillResponseDTO {
	private Long id;
	private String foto;
	private String nome;
	private String descricao;
	private String nivel;
	
	public SkillResponseDTO() {
	}
	public SkillResponseDTO(Skill i) {
		this.id = i.getId();
		this.foto = i.getUrl();
		this.nome=i.getNome();
		this.descricao=i.getDescricao();
		this.nivel = NivelENUM.BASICO.getNivel(); 
	}
	public SkillResponseDTO(UsuarioSkill i) {
		this.id = i.getId().getSkill().getId();
		this.foto = i.getId().getSkill().getUrl();
		this.nome= i.getId().getSkill().getNome();
		this.descricao = i.getId().getSkill().getDescricao();
		this.nivel = i.getNivel().getNivel();
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	
}
