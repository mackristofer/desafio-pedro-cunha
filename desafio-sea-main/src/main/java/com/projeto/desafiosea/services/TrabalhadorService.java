package com.projeto.desafiosea.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.desafiosea.dto.TrabalhadorDTO;
import com.projeto.desafiosea.entities.Cargo;
import com.projeto.desafiosea.entities.Trabalhador;
import com.projeto.desafiosea.repositories.CargoRepository;
import com.projeto.desafiosea.repositories.TrabalhadorRepository;
import com.projeto.desafiosea.services.exceptions.DataBaseException;
import com.projeto.desafiosea.services.exceptions.ResourceNotFoundException;

@Service
public class TrabalhadorService {

	@Autowired
	private TrabalhadorRepository repository;

	@Autowired
	private CargoRepository cargoRepository;

	@Transactional(readOnly = true)
	public List<TrabalhadorDTO> findAll() {
		List<Trabalhador> list = repository.findAll();
		return list.stream().map(x -> new TrabalhadorDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public TrabalhadorDTO findById(Long id) {
		Optional<Trabalhador> obj = repository.findById(id);
		Trabalhador entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new TrabalhadorDTO(entity);
	}

	@Transactional
	public TrabalhadorDTO insert(TrabalhadorDTO dto) {
		try {
			Trabalhador entity = new Trabalhador();
			entity.setName(dto.getName());
			entity.setCpf(dto.getCpf());
			entity.setSexo(dto.getSexo());
			@SuppressWarnings("deprecation")
			Cargo cargo = cargoRepository.getOne(dto.getCargo().getId());
			entity.setCargo(cargo);
			entity = repository.save(entity);
			return new TrabalhadorDTO(entity);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation");
		}
	}

	@Transactional
	public TrabalhadorDTO update(Long id, TrabalhadorDTO dto) {
		try {
			@SuppressWarnings("deprecation")
			Trabalhador entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity.setCpf(dto.getCpf());
			entity.setSexo(dto.getSexo());
			@SuppressWarnings("deprecation")
			Cargo cargo = cargoRepository.getOne(dto.getCargo().getId());
			entity.setCargo(cargo);
			return new TrabalhadorDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}catch(DataIntegrityViolationException e){
			throw new DataBaseException("Integrity violation");
		}	
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation");
		}
	}

}
