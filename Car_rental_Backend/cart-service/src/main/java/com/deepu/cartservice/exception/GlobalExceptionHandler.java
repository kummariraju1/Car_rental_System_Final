package com.deepu.cartservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CartItemNotFoundexception.class)
	public ResponseEntity<String> CartItemNotFoundexception(CartItemNotFoundexception ex){
		return new ResponseEntity<String>("CartItem not Found Exception",HttpStatus.NOT_FOUND);
	}
}
