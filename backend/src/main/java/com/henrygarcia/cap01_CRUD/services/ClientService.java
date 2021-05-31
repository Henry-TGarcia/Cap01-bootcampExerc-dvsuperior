package com.henrygarcia.cap01_CRUD.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henrygarcia.cap01_CRUD.entities.Client;
import com.henrygarcia.cap01_CRUD.repositories.ClientRepository;

@Service
public class ClientService {

	//Associação
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
}
