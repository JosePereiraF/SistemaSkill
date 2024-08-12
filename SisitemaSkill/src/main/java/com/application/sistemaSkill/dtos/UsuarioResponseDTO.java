package com.application.sistemaSkill.dtos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.application.sistemaSkill.entity.Usuario;
import com.application.sistemaSkill.entity.UsuarioSkill;

public class UsuarioResponseDTO {
	private Long id;
	private String nome;
	private String login;
	private String senha;
	private String url;
	private List<SkillResponseDTO> skills;
	
	public UsuarioResponseDTO(Usuario u) {
		this.id= u.getId();
		this.nome= u.getNome();
		this.login= u.getLogin();
		this.senha= u.getSenha();
		this.skills =listarSkills(u.getSkills());
	}
	public List<SkillResponseDTO> listarSkills(Set<UsuarioSkill> lista){
		return lista.stream().map(i -> new SkillResponseDTO(i)).collect(Collectors.toList());
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<SkillResponseDTO> getSkills() {
		return skills;
	}
	public void setSkills(List<SkillResponseDTO> skills) {
		this.skills = skills;
	}
	
	
}
