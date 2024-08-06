package com.application.sistemaSkill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.sistemaSkill.dtos.AtualizarSkillRequestDTO;
import com.application.sistemaSkill.dtos.ExcluirUsuarioSkillDTO;
import com.application.sistemaSkill.dtos.UsuarioSkillRequestDTO;
import com.application.sistemaSkill.dtos.UsuarioSkillResponseDTO;
import com.application.sistemaSkill.service.UsuarioSkillService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarioSkill")
public class UsuarioSkillController {
	@Autowired
	private UsuarioSkillService service;
	@GetMapping("/{id}")
	public ResponseEntity<List<UsuarioSkillResponseDTO>>listarSkillUsuario(@PathVariable Long id){
		return new ResponseEntity<>(service.listarSkillUsuario(id),HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<List<UsuarioSkillResponseDTO>> salvarSkill(@Valid @RequestBody UsuarioSkillRequestDTO usuarioSkill){
		return new ResponseEntity<>(service.salvarSKills(usuarioSkill),HttpStatus.CREATED);
	}
	@PutMapping
	public ResponseEntity<UsuarioSkillResponseDTO> atualizarSkill(@RequestBody AtualizarSkillRequestDTO a){
		return new ResponseEntity<>(service.atualizarSkill(a),HttpStatus.OK);
	}
	@DeleteMapping//isso pode gerar erro porque o delete mapping não tem body talvez eu va ter que passar isso no path
	public ResponseEntity<String> excluirUsuarioSkill(@Valid @RequestBody ExcluirUsuarioSkillDTO e){
		return new ResponseEntity<>(service.excluirUsuarioSkill(e),HttpStatus.NO_CONTENT);
	}
}
