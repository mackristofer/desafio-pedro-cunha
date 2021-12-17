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

import com.projeto.desafiosea.dto.SetorDTO;
import com.projeto.desafiosea.entities.Setor;
import com.projeto.desafiosea.repositories.SetorRepository;
import com.projeto.desafiosea.services.exceptions.DataBaseException;
import com.projeto.desafiosea.services.exceptions.ResourceNotFoundException;

@Service
public class SetorService {

	@Autowired
	private SetorRepository repository;
	
	@Transactional(readOnly = true)
	public List<SetorDTO> findAll() {
		List<Setor> list = repository.findAll();
		return list.stream().map(x -> new SetorDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public SetorDTO findById(Long id) {
		Optional<Setor> obj = repository.findById(id);
		Setor entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new SetorDTO(entity);
	}

	@Transactional
	public SetorDTO insert(SetorDTO dto) {
		try {
		Setor entity = new Setor();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new SetorDTO(entity);
		}catch(DataIntegrityViolationException e){
			throw new DataBaseException("Integrity violation");
		}	
	}

	@Transactional
	public SetorDTO update(Long id, SetorDTO dto) {
		try {
			@SuppressWarnings("deprecation")
			Setor entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new SetorDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	    catch(DataIntegrityViolationException e){
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
