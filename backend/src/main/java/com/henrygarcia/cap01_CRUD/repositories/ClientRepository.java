package com.henrygarcia.cap01_CRUD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henrygarcia.cap01_CRUD.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>  {

}
