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
import com.application.sistemaSkill.dtos.UsuarioResponseDTO;
import com.application.sistemaSkill.dtos.UsuarioSkillRequestDTO;
import com.application.sistemaSkill.dtos.UsuarioSkillResponseDTO;
import com.application.sistemaSkill.exceptions.ResourceNotFoundException;
import com.application.sistemaSkill.service.UsuarioSkillService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarioSkill")
@Tag(name = "UsuarioSkill" ,description = "Controlador da classe UsuarioSkill")
public class UsuarioSkillController {
	@Autowired
	private UsuarioSkillService service;
	@GetMapping("/{id}")
	@Operation(summary = "Metodo para buscar todas skills de um usuario")
	@ApiResponse(responseCode = "200", description = "Sucesso",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = UsuarioSkillResponseDTO.class))})
	@ApiResponse(responseCode = "400",description = "Falha em realizar a requisição por envio de recurso incorreto",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = ResourceNotFoundException.class))})
	@ApiResponse(responseCode = "500",description = "Erro no servidor",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Exception.class))})
	public ResponseEntity<List<UsuarioSkillResponseDTO>>listarSkillUsuario(@PathVariable Long id){
		return new ResponseEntity<>(service.listarSkillUsuario(id),HttpStatus.OK);
	}
	@PostMapping
	@Operation(summary = "Metodo para atribuir uma skill a um usuario")
	@ApiResponse(responseCode = "201", description = "Sucesso",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = UsuarioSkillResponseDTO.class))})
	@ApiResponse(responseCode = "400",description = "Falha em realizar a requisição por envio de recurso incorreto",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = ResourceNotFoundException.class))})
	@ApiResponse(responseCode = "500",description = "Erro no servidor",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Exception.class))})
	public ResponseEntity<List<UsuarioSkillResponseDTO>> salvarSkill(@Valid @RequestBody UsuarioSkillRequestDTO usuarioSkill){
		return new ResponseEntity<>(service.salvarSKills(usuarioSkill),HttpStatus.CREATED);
	}
	@PutMapping
	@Operation(summary = "Metodo para Atualizar o nivel da skill do usuario")
	@ApiResponse(responseCode = "200", description = "Sucesso",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = UsuarioSkillResponseDTO.class))})
	@ApiResponse(responseCode = "400",description = "Falha em realizar a requisição por envio de recurso incorreto",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = ResourceNotFoundException.class))})
	@ApiResponse(responseCode = "500",description = "Erro no servidor",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Exception.class))})
	public ResponseEntity<UsuarioSkillResponseDTO> atualizarSkill(@RequestBody AtualizarSkillRequestDTO a){
		return new ResponseEntity<>(service.atualizarSkill(a),HttpStatus.OK);
	}
	@PutMapping("/deletar")
	@Operation(summary = "Metodo para desatribuir a skill do usuario")
	@ApiResponse(responseCode = "204", description = "Sucesso",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = String.class))})
	@ApiResponse(responseCode = "400",description = "Falha em realizar a requisição por envio de recurso incorreto",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = ResourceNotFoundException.class))})
	@ApiResponse(responseCode = "500",description = "Erro no servidor",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Exception.class))})
	public ResponseEntity<String> excluirUsuarioSkill(@RequestBody ExcluirUsuarioSkillDTO e){
		System.out.println(e.toString());
		return new ResponseEntity<>(service.excluirUsuarioSkill(e),HttpStatus.NO_CONTENT);
	}
}
