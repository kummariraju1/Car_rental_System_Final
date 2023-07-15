package com.deepu.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {
	private static final long serialVersionUID = 1L;
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<String> userNotFound(UserNotFoundException ex){
		return new ResponseEntity<String>("User not found",HttpStatus.NOT_FOUND);
	}
}
