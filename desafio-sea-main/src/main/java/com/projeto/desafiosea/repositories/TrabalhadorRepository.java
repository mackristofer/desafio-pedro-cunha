package com.projeto.desafiosea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.desafiosea.entities.Trabalhador;

@Repository
public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Long> {

}
