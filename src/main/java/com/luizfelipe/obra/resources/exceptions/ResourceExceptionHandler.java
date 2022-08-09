package com.luizfelipe.obra.resources.exceptions;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.luizfelipe.obra.services.exceptions.ObjetoNaoEncontradoException;
import com.luizfelipe.obra.services.exceptions.ViolacaoIntegracaoDadosException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<StandardError> objetoNaoEncontradoException(ObjetoNaoEncontradoException ex, HttpServletRequest request) {

		StandardError error = new StandardError(
				System.currentTimeMillis(), 
				HttpStatus.NOT_FOUND.value(), 
				"Objeto não encontrado",
				ex.getMessage(),
				request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(ViolacaoIntegracaoDadosException.class)
	public ResponseEntity<StandardError> violacaoIntegracaoDadosException(ViolacaoIntegracaoDadosException ex, HttpServletRequest request) {

		StandardError error = new StandardError(
				System.currentTimeMillis(), 
				HttpStatus.BAD_REQUEST.value(), 
				"Violação de dados",
				ex.getMessage(),
				request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationErros(MethodArgumentNotValidException ex, HttpServletRequest request) {

		ValidationError errors = new ValidationError(
				System.currentTimeMillis(), 
				HttpStatus.BAD_REQUEST.value(), 
				"Validation error",
				"Erro na validação dos campos",
				request.getRequestURI());
		
		for(FieldError x : ex.getBindingResult().getFieldErrors()) {
			errors.addError(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

}
