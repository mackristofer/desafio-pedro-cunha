package com.projeto.desafiosea.dto;

import java.io.Serializable;

import com.projeto.desafiosea.entities.Cargo;

public class CargoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private SetorDTO setor;
	
	public CargoDTO() {
		
	}

	public CargoDTO(Long id, String nome, SetorDTO setor) {
		this.id = id;
		this.nome = nome;
		this.setor = setor;
	}
	
	public CargoDTO(Cargo entity) {
		id = entity.getId();
		nome = entity.getNome();
		setor = new SetorDTO(entity.getSetor());
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

	public SetorDTO getSetor() {
		return setor;
	}

	public void setSetor(SetorDTO setor) {
		this.setor = setor;
	}
	
	

}
