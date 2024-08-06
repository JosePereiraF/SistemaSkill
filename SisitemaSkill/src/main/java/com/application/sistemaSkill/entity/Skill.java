package com.application.sistemaSkill.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.application.sistemaSkill.dtos.SkillRequestDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String url;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	
	@OneToMany(mappedBy = "id.skill",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<UsuarioSkill> usuarios = new HashSet<>();
	public Skill() {
	}
	public Skill(SkillRequestDTO skill) {
		this.nome = skill.getNome();
		this.descricao= skill.getDescricao();
		this.criadoEm = LocalDateTime.now();
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
	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}
	public void setCriadoEm(LocalDateTime criadoEm) {
		this.criadoEm = criadoEm;
	}
	public LocalDateTime getAtualizadoEm() {
		return atualizadoEm;
	}
	public void setAtualizadoEm(LocalDateTime atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}
	public Set<UsuarioSkill> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Set<UsuarioSkill> usuarios) {
		this.usuarios = usuarios;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
