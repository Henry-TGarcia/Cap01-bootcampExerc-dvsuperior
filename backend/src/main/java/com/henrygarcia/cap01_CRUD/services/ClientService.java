package com.henrygarcia.cap01_CRUD.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.henrygarcia.cap01_CRUD.dto.ClientDTO;
import com.henrygarcia.cap01_CRUD.entities.Client;
import com.henrygarcia.cap01_CRUD.repositories.ClientRepository;
import com.henrygarcia.cap01_CRUD.services.exceptions.EntityNotFoundException;

@Service
public class ClientService {

	//Associação
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> lista = repository.findAll();
		
		return lista.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> opt = repository.findById(id);
		Client entity = opt.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
		return new ClientDTO(entity);
		
	}
}
