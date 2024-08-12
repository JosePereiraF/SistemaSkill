package com.application.sistemaSkill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.application.sistemaSkill.dtos.SkillRequestDTO;
import com.application.sistemaSkill.dtos.SkillResponseDTO;
import com.application.sistemaSkill.entity.FotoSkill;
import com.application.sistemaSkill.exceptions.ResourceNotFoundException;
import com.application.sistemaSkill.service.FotoSkillService;
import com.application.sistemaSkill.service.SkillService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/skill")
@Tag(name = "Skill" ,description = "Controlador da classe Skill")
public class SkillController {

	@Autowired
	private SkillService service;
	@Autowired
	private FotoSkillService fotoService;
	
	@GetMapping
	@Operation(summary = "Metodo para listar todas skills cadastradas no site")
	@ApiResponse(responseCode = "200", description = "Sucesso",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = SkillResponseDTO.class))})
	@ApiResponse(responseCode = "500",description = "Erro no servidor",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Exception.class))})
	public ResponseEntity<List<SkillResponseDTO>>listarSkills(){
		return new ResponseEntity<>(service.listarSkill(),HttpStatus.OK);
	}
	@GetMapping("/foto/{id}")
	@Operation(summary = "Metodo para buscar foto da skill.")
	@ApiResponse(responseCode = "200", description = "Sucesso",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Byte.class))})
	@ApiResponse(responseCode = "400",description = "Falha em realizar a requisição por envio de recurso incorreto",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = ResourceNotFoundException.class))})
	@ApiResponse(responseCode = "500",description = "Erro no servidor",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Exception.class))})
	public ResponseEntity<byte[]>buscarFoto(@PathVariable Long id){
		FotoSkill foto = fotoService.buscarFoto(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", foto.getTipo());
		headers.add("Content-length", String.valueOf(foto.getDados().length));
		return new ResponseEntity<>(foto.getDados(), headers, HttpStatus.OK);
	}
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Operation(summary = "Metodo para salvar novas skills")
	@ApiResponse(responseCode = "201", description = "Sucesso",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = SkillResponseDTO.class))})
	@ApiResponse(responseCode = "400",description = "Falha em realizar a requisição por envio de recurso incorreto",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = ResourceNotFoundException.class))})
	@ApiResponse(responseCode = "500",description = "Erro no servidor",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Exception.class))})
	public ResponseEntity<SkillResponseDTO>salvar(@Valid @RequestPart SkillRequestDTO skill, @RequestPart MultipartFile file){
		return new ResponseEntity<>(service.salvarSkill(skill,file),HttpStatus.CREATED);
	}
	
}
