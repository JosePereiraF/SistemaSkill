package com.application.sistemaSkill.dtos;

import com.application.sistemaSkill.entity.UsuarioSkill;

public class UsuarioSkillResponseDTO {
	private Long idUsuario;
	private Long id;
	private String foto;
	private String nome;
	private String descricao;
	private String nivel;

	public UsuarioSkillResponseDTO() {
	}
	public UsuarioSkillResponseDTO(UsuarioSkill i) {
		this.idUsuario = i.getId().getUsuario().getId();
		this.id = i.getId().getSkill().getId();
		this.nome = i.getId().getSkill().getNome();
		this.descricao =i.getId().getSkill().getDescricao();
		this.foto = i.getId().getSkill().getUrl();
		this.nivel = i.getNivel().getNivel();
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	
}
