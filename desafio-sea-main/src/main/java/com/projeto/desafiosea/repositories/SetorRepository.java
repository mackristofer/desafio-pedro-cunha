package com.projeto.desafiosea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.desafiosea.entities.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

}
