package com.application.sistemaSkill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.application.sistemaSkill.dtos.UsuarioRequestDTO;
import com.application.sistemaSkill.dtos.UsuarioResponseDTO;
import com.application.sistemaSkill.exceptions.ResourceNotFoundException;
import com.application.sistemaSkill.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Usuario" ,description = "Controlador da classe Usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	
	@GetMapping
	@Operation(summary = "Metodo para listar todos os usuarios")
	@ApiResponse(responseCode = "200", description = "Sucesso",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = UsuarioResponseDTO.class))})
	@ApiResponse(responseCode = "500",description = "Erro no servidor",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Exception.class))})
	public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios(){
		return new ResponseEntity<>(service.listarUsuario(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@Operation(summary = "Metodo para buscar usuarios pelo id")
	@ApiResponse(responseCode = "200", description = "Sucesso",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = UsuarioResponseDTO.class))})
	@ApiResponse(responseCode = "500",description = "Erro no servidor",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Exception.class))})
	public ResponseEntity<UsuarioResponseDTO>buscarUsuario(@PathVariable Long id){
		return new ResponseEntity<>(service.buscarUsuario(id),HttpStatus.OK);
	}

	@PostMapping
	@Operation(summary = "Metodo para salvar novo usuario")
	@ApiResponse(responseCode = "201", description = "Sucesso",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = UsuarioResponseDTO.class))})
	@ApiResponse(responseCode = "400",description = "Falha em realizar a requisição por envio de recurso incorreto",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = ResourceNotFoundException.class))})
	@ApiResponse(responseCode = "500",description = "Erro no servidor",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Exception.class))})
	public ResponseEntity<UsuarioResponseDTO> salvarUsuario(@Valid @RequestBody UsuarioRequestDTO usuario){
		return new ResponseEntity<>(service.salvarUsuarioTeste(usuario),HttpStatus.CREATED);
	}
	
}
