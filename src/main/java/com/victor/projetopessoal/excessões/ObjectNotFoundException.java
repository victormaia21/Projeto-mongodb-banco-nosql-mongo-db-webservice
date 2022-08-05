package com.victor.projetopessoal.excessões;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ObjectNotFoundException {

	@ExceptionHandler(ExcessãoProcurarPorId.class)
	public ResponseEntity<StandadError>excessão(ExcessãoProcurarPorId e,HttpServletRequest request) {
		String erro = "ID NÃO ENCONTRADO";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandadError se = new StandadError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(se);
	}
}
