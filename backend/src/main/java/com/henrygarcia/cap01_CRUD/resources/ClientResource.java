package com.henrygarcia.cap01_CRUD.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henrygarcia.cap01_CRUD.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> lista = new ArrayList<>();
		lista.add(new Client(1L, "Henry Garcia", "400.200.433", 2500.0, null, 0));
		lista.add(new Client(2L, "Marcia Garcia", "050.020.948", 15500.0, null, 1));
		
		return ResponseEntity.ok().body(lista);
	}
}
