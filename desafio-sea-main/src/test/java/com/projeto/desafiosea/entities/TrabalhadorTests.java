package com.projeto.desafiosea.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TrabalhadorTests {
	
	@Test
	public void trabalhadorShouldHaveCorrectStructure() {
		Trabalhador entity = new Trabalhador();
		entity.setId(1L);
		entity.setName("Trabalhador teste");
		entity.setCpf("000.000.000-00");
		entity.setSexo("m");
		entity.setCargo(new Cargo());
		
		Assertions.assertNotNull(entity.getId());
		Assertions.assertNotNull(entity.getName());
		Assertions.assertNotNull(entity.getCpf());
		Assertions.assertNotNull(entity.getSexo());
		Assertions.assertNotNull(entity.getCargo());
		
	}

}
