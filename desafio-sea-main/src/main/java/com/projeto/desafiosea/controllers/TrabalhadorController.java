package com.projeto.desafiosea.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.desafiosea.dto.TrabalhadorDTO;
import com.projeto.desafiosea.services.TrabalhadorService;


@RestController
@RequestMapping(value = "/trabalhador")
public class TrabalhadorController {
	
	@Autowired
	private TrabalhadorService service;
	
	@GetMapping
	public ResponseEntity<List<TrabalhadorDTO>> findAll(){
			List<TrabalhadorDTO> list = service.findAll();
			return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TrabalhadorDTO> finById(@PathVariable Long id) {
		TrabalhadorDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	

	@PostMapping
	public ResponseEntity<TrabalhadorDTO> insert(@RequestBody TrabalhadorDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TrabalhadorDTO> update(@PathVariable Long id, @RequestBody TrabalhadorDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
