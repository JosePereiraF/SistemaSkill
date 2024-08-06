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

import com.application.sistemaSkill.dtos.UsuarioRequestDTO;
import com.application.sistemaSkill.dtos.UsuarioResponseDTO;
import com.application.sistemaSkill.entity.FotoUsuario;
import com.application.sistemaSkill.entity.Usuario;
import com.application.sistemaSkill.service.FotoUsuarioService;
import com.application.sistemaSkill.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	@Autowired
	private FotoUsuarioService fotoService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios(){
		return new ResponseEntity<>(service.listarUsuario(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponseDTO>buscarUsuario(@PathVariable Long id){
		return new ResponseEntity<>(service.buscarUsuario(id),HttpStatus.OK);
	}
	@GetMapping("/foto/{id}")
	public ResponseEntity<byte[]>buscarFoto(@PathVariable Long id){
		FotoUsuario foto = fotoService.buscarFoto(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", foto.getTipo());
		headers.add("Content-length", String.valueOf(foto.getDados().length));
		return new ResponseEntity<>(foto.getDados(), headers, HttpStatus.OK);
	}
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<UsuarioResponseDTO>salvarUsuario(@Valid @RequestPart UsuarioRequestDTO usuario, @RequestPart MultipartFile file) {
		return new ResponseEntity<>(service.salvarUsuario(usuario, file),HttpStatus.CREATED);
	}
	
}
