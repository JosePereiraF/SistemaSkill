package com.application.sistemaSkill.entity;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class FotoSkill {
	@Id
	private Long id;
	@Lob
	private byte[] dados;
	private String tipo;
	private String nome;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_skill")
	private Skill skill;
	public FotoSkill() {
	}
	public FotoSkill(Skill skill, MultipartFile file) throws IOException {
		this.id = skill.getId();
		this.dados=file.getBytes();
		this.nome = file.getName();
		this.tipo = file.getContentType();
		this.skill = skill;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getDados() {
		return dados;
	}
	public void setDados(byte[] dados) {
		this.dados = dados;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	
}
