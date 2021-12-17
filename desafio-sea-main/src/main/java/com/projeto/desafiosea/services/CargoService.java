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

import com.projeto.desafiosea.dto.CargoDTO;
import com.projeto.desafiosea.entities.Cargo;
import com.projeto.desafiosea.entities.Setor;
import com.projeto.desafiosea.repositories.CargoRepository;
import com.projeto.desafiosea.repositories.SetorRepository;
import com.projeto.desafiosea.services.exceptions.DataBaseException;
import com.projeto.desafiosea.services.exceptions.ResourceNotFoundException;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;

	@Autowired
	private SetorRepository setorRepository;

	@Transactional(readOnly = true)
	public List<CargoDTO> findAll() {
		List<Cargo> list = repository.findAll();
		return list.stream().map(x -> new CargoDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public CargoDTO findById(Long id) {
		Optional<Cargo> obj = repository.findById(id);
		Cargo entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new CargoDTO(entity);
	}

	@Transactional
	public CargoDTO insert(CargoDTO dto) {
		try {
			Cargo entity = new Cargo();
			entity.setName(dto.getName());
			@SuppressWarnings("deprecation")
			Setor setor = setorRepository.getOne(dto.getSetor().getId());
			entity.setSetor(setor);
			entity = repository.save(entity);
			return new CargoDTO(entity);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation");
		}
	}

	@Transactional
	public CargoDTO update(Long id, CargoDTO dto) {
		try {
			@SuppressWarnings("deprecation")
			Cargo entity = repository.getOne(id);
			entity.setName(dto.getName());
			@SuppressWarnings("deprecation")
			Setor setor = setorRepository.getOne(dto.getSetor().getId());
			entity.setSetor(setor);
			entity = repository.save(entity);
			return new CargoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (
		DataIntegrityViolationException e) {
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
