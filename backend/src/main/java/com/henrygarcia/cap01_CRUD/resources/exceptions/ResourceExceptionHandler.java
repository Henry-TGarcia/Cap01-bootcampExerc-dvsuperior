package com.henrygarcia.cap01_CRUD.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.henrygarcia.cap01_CRUD.services.exceptions.EntityNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException en, HttpServletRequest request){
		StandardError error = new StandardError();
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value()); //codigo 404
		error.setError("Rosource not found");
		error.setMessage(en.getMessage());
		error.setPath(request.getRequestURI()); //Pega o caminho da requisição

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
