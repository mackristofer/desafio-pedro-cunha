package com.projeto.desafiosea.dto;

import java.io.Serializable;

import com.projeto.desafiosea.entities.Trabalhador;

public class TrabalhadorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	private String cpf;
	private String sexo;

	private CargoDTO cargo;
	
	
	public TrabalhadorDTO() {
		
	}
	
	public TrabalhadorDTO(Long id, String name, String cpf, String sexo, CargoDTO cargo) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.sexo = sexo;
		this.cargo = cargo;
	}



	public TrabalhadorDTO(Trabalhador entity) {
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		sexo = entity.getSexo();
		cargo = new CargoDTO(entity.getCargo());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public CargoDTO getCargo() {
		return cargo;
	}

	public void setCargo(CargoDTO cargo) {
		this.cargo = cargo;
	}

	
}
