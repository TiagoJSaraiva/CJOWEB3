package br.edu.ifspcjo.ads.web3.ExercicioFixacao2.todo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.converter.HttpMessageNotReadableException;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> onValidation(MethodArgumentNotValidException ex) {
		var errors = new HashMap<String, Object>();
		errors.put("status", 400);
		errors.put("error", "Bad Request");

		var details = ex.getBindingResult().getFieldErrors().stream()
				.map(fe -> new Err(fe.getField(), fe.getDefaultMessage())).toList();

		errors.put("details", details);
		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> onUnreadable(HttpMessageNotReadableException ex) {
		var body = new HashMap<String, Object>();
		body.put("status", 400);
		body.put("error", "Bad Request");
		body.put("message", "JSON inválido ou contém atributos desconhecidos");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}

	record Err(String field, String message) {
	}
}