package com.projeto.desafiosea.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.projeto.desafiosea.entities.Cargo;
import com.projeto.desafiosea.entities.Setor;

public class SetorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	private List<CargoDTO> cargos = new ArrayList<>();
	
	public SetorDTO() {
		
	}

	public SetorDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public SetorDTO(Setor entity) {
		id = entity.getId();
		nome = entity.getNome();
	}
	
	public SetorDTO(Setor entity, List<Cargo> cargos) {
		this(entity);
		for(Cargo c : cargos) {
			this.cargos.add(new CargoDTO(c));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CargoDTO> getCargos() {
		return cargos;
	}
	
	

}
