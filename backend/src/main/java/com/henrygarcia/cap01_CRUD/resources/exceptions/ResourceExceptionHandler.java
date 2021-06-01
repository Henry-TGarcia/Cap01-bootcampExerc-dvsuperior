package com.henrygarcia.cap01_CRUD.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.henrygarcia.cap01_CRUD.services.exceptions.DatabaseException;
import com.henrygarcia.cap01_CRUD.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException en, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(status.value()); //codigo 404
		error.setError("Rosource not found");
		error.setMessage(en.getMessage());
		error.setPath(request.getRequestURI()); //Pega o caminho da requisição

		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException en, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(status.value()); //codigo 400-erro de requisição
		error.setError("Database exception");
		error.setMessage(en.getMessage());
		error.setPath(request.getRequestURI()); //Pega o caminho da requisição

		return ResponseEntity.status(status).body(error);
	}
}
