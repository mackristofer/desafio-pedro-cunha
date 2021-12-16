package com.projeto.desafiosea.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.desafiosea.dto.SetorDTO;


@RestController
@RequestMapping(value = "/setor")
public class SetorController {
	@PostMapping
	public ResponseEntity<SetorDTO> insert(@RequestBody SetorDTO dto) {
		//dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);

	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<SetorDTO> update(@PathVariable Long id, @RequestBody SetorDTO dto) {
		//dto = service.update(id, dto);
		
		return ResponseEntity.ok(dto);

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<SetorDTO> delete(@PathVariable Long id) {
		//service.delete(id);

		return ResponseEntity.noContent().build();
	}
}
