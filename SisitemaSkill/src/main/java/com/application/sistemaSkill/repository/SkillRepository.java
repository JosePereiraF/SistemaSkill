package com.application.sistemaSkill.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.sistemaSkill.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long>{
	Optional<Skill> findByNome(String nome);
}
