package com.application.sistemaSkill.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import com.application.sistemaSkill.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByLogin(String login);
	@Query("SELECT u FROM Usuario u WHERE u.login= :login")
	UserDetails userDetaisLogin(@Param("login")String login);
	
}
