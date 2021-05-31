package com.henrygarcia.cap01_CRUD.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.henrygarcia.cap01_CRUD.dto.ClientDTO;
import com.henrygarcia.cap01_CRUD.entities.Client;
import com.henrygarcia.cap01_CRUD.repositories.ClientRepository;

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
}
