package com.projeto.desafiosea.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CargoTests {
	
	@Test
	public void cargoShouldHaveCorrectStructure() {
		Cargo entity = new Cargo();
		entity.setId(1L);
		entity.setName("Logistica");
		entity.setSetor(new Setor());
		
		Assertions.assertNotNull(entity.getId());
		Assertions.assertNotNull(entity.getName());
		Assertions.assertNotNull(entity.getSetor());
		
	}

}
