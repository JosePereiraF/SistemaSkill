package com.application.sistemaSkill.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.application.sistemaSkill.entity.UsuarioSkill;
import com.application.sistemaSkill.entity.UsuarioSkillId;

public interface UsuarioSkillRepository extends JpaRepository<UsuarioSkill, UsuarioSkillId>{
	@Query("SELECT us FROM UsuarioSkill us WHERE us.id.usuario.id =:idUsuario AND us.id.skill.id =:idSkill")
	Optional<UsuarioSkill> buscarUsuarioSkill(@Param("idUsuario")Long idUsuario,@Param("idSkill")Long idSkill);
	/*DELETE FROM USUARIO_SKILL
	WHERE id_USUARIO = 1
			AND ID_SKILL =2;*/
	@Modifying//Usar essa anotação quando for fazer query diferente de SELECT
	@Query("DELETE FROM UsuarioSkill us WHERE us.id.usuario.id =:idUsuario AND us.id.skill.id =:idSkill")
	void deletarUsuarioSkill(@Param("idUsuario")Long idUsuario,@Param("idSkill")Long idSkill);
	
}
