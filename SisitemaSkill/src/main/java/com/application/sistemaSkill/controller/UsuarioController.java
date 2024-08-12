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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.application.sistemaSkill.dtos.SkillResponseDTO;
import com.application.sistemaSkill.dtos.UsuarioRequestDTO;
import com.application.sistemaSkill.dtos.UsuarioResponseDTO;
import com.application.sistemaSkill.entity.FotoUsuario;
import com.application.sistemaSkill.entity.Usuario;
import com.application.sistemaSkill.exceptions.ResourceNotFoundException;
import com.application.sistemaSkill.service.FotoUsuarioService;
import com.application.sistemaSkill.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
@Tag(name = "Skill" ,description = "Controlador da classe Usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	@Autowired
	private FotoUsuarioService fotoService;
	
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
	@GetMapping("/foto/{id}")
	@Operation(summary = "Metodo para buscar foto pelo id")
	@ApiResponse(responseCode = "200", description = "Sucesso",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Byte.class))})
	@ApiResponse(responseCode = "400",description = "Falha em realizar a requisição por envio de recurso incorreto",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = ResourceNotFoundException.class))})
	@ApiResponse(responseCode = "500",description = "Erro no servidor",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Exception.class))})
	public ResponseEntity<byte[]>buscarFoto(@PathVariable Long id){
		FotoUsuario foto = fotoService.buscarFoto(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", foto.getTipo());
		headers.add("Content-length", String.valueOf(foto.getDados().length));
		return new ResponseEntity<>(foto.getDados(), headers, HttpStatus.OK);
	}
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Operation(summary = "Metodo para salvar novo usuario")
	@ApiResponse(responseCode = "201", description = "Sucesso",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = UsuarioResponseDTO.class))})
	@ApiResponse(responseCode = "400",description = "Falha em realizar a requisição por envio de recurso incorreto",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = ResourceNotFoundException.class))})
	@ApiResponse(responseCode = "500",description = "Erro no servidor",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Exception.class))})
	public ResponseEntity<UsuarioResponseDTO>salvarUsuario(@Valid @RequestPart UsuarioRequestDTO usuario, @RequestPart MultipartFile file) {
		return new ResponseEntity<>(service.salvarUsuario(usuario, file),HttpStatus.CREATED);
	}
	@PostMapping("/teste")
	@Operation(summary = "Metodo para salvar novo usuario")
	@ApiResponse(responseCode = "201", description = "Sucesso",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = UsuarioResponseDTO.class))})
	@ApiResponse(responseCode = "400",description = "Falha em realizar a requisição por envio de recurso incorreto",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = ResourceNotFoundException.class))})
	@ApiResponse(responseCode = "500",description = "Erro no servidor",content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Exception.class))})
	public ResponseEntity<UsuarioResponseDTO> salvarUsuario(@Valid @RequestBody UsuarioRequestDTO usuario){
		return new ResponseEntity<>(service.salvarUsuarioTeste(usuario),HttpStatus.CREATED);
	}
	
}
