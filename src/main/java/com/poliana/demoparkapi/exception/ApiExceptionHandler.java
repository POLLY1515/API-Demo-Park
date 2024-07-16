package com.poliana.demoparkapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;


@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage>methodArgumentNotvalidException(MethodArgumentNotValidException ex,
			HttpServletRequest request, BindingResult result){
		
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).contentType(MediaType.APPLICATION_JSON)
				.body(new ErrorMessage(request, HttpStatus.UNPROCESSABLE_ENTITY, "Campo(s)"
						+ "inválido(s)", result));
	} 
	
	@ExceptionHandler(	UsernameUniqueViolationException.class)
	public ResponseEntity<ErrorMessage>uniqueViolationException(RuntimeException ex,
			HttpServletRequest request){
		
		return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON)
				.body(new ErrorMessage(request, HttpStatus.CONFLICT, ex.getMessage()));
	} 
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorMessage>entityNotFoundException(MethodArgumentNotValidException ex,
			HttpServletRequest request, BindingResult result){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON)
				.body(new ErrorMessage(request, HttpStatus.NOT_FOUND,ex.getMessage()));
	} 
	
}
