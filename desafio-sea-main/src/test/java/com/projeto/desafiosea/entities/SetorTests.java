package com.projeto.desafiosea.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SetorTests {
	
	@Test
	public void setorShouldHaveCorrectStructure() {
		Setor entity = new Setor();
		entity.setId(1L);
		entity.setName("Logistica");
		
		Assertions.assertNotNull(entity.getId());
		Assertions.assertNotNull(entity.getName());
		
	}

}
