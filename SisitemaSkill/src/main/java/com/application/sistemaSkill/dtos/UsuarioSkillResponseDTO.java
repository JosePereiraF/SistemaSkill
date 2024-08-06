package com.application.sistemaSkill.dtos;

import com.application.sistemaSkill.entity.UsuarioSkill;

public class UsuarioSkillResponseDTO {
	private Long idUsuario;
	private Long idSkill;
	private String url;
	private String nome;
	private String descricao;
	private String level;
	public UsuarioSkillResponseDTO() {
	}
	public UsuarioSkillResponseDTO(UsuarioSkill i) {
		this.idUsuario = i.getId().getUsuario().getId();
		this.idSkill = i.getId().getSkill().getId();
		this.nome = i.getId().getSkill().getNome();
		this.descricao =i.getId().getSkill().getDescricao();
		this.url = i.getId().getSkill().getUrl();
		this.level = i.getNivel().getNivel();
	}
	
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
