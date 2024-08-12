package com.application.sistemaSkill.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.application.sistemaSkill.dtos.UsuarioRequestDTO;
import com.application.sistemaSkill.enums.CargoENUM;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String login;
	private String senha;
	private CargoENUM role;
	private LocalDateTime criadoEm;
	private LocalDateTime atualizadoEm;
	
	@OneToMany(mappedBy = "id.usuario",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<UsuarioSkill> skills = new HashSet<>();
	
	public Usuario() {
	}
	public Usuario(UsuarioRequestDTO usuario) {
		this.nome = usuario.getNome();
		this.login= usuario.getLogin();
		this.criadoEm = LocalDateTime.now();
		this.role = CargoENUM.ROLE_USUARIO;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.role == CargoENUM.ROLE_USUARIO)
			return List.of(new SimpleGrantedAuthority("usuario"));
		return null;
	}
	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
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
	public Set<UsuarioSkill> getSkills() {
		return skills;
	}
	public void setSkills(Set<UsuarioSkill> skills) {
		this.skills = skills;
	}
	public CargoENUM getRole() {
		return role;
	}
	public void setRole(CargoENUM role) {
		this.role = role;
	}
	


}
