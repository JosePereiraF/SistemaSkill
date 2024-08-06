package com.application.sistemaSkill.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.sistemaSkill.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByLogin(String login);
}
