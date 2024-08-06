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
import com.application.sistemaSkill.entity.FotoUsuario;
import com.application.sistemaSkill.service.FotoSkillService;
import com.application.sistemaSkill.service.SkillService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	private SkillService service;
	@Autowired
	private FotoSkillService fotoService;
	
	@GetMapping
	public ResponseEntity<List<SkillResponseDTO>>listarSkills(){
		return new ResponseEntity<>(service.listarSkill(),HttpStatus.OK);
	}
	@GetMapping("/foto/{id}")
	public ResponseEntity<byte[]>buscarFoto(@PathVariable Long id){
		FotoSkill foto = fotoService.buscarFoto(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", foto.getTipo());
		headers.add("Content-length", String.valueOf(foto.getDados().length));
		return new ResponseEntity<>(foto.getDados(), headers, HttpStatus.OK);
	}
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<SkillResponseDTO>salvar(@Valid @RequestPart SkillRequestDTO skill, @RequestPart MultipartFile file){
		return new ResponseEntity<>(service.salvarSkill(skill,file),HttpStatus.CREATED);
	}
	
}
