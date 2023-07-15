package com.deepu.vehicle.exception;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {
	@ExceptionHandler(value=VehicleNotFoundException.class)

	public ResponseEntity<String> vehicleNotFound(VehicleNotFoundException ex){

	return new ResponseEntity<String>("Vehicle Not Found",HttpStatus.NOT_FOUND);
}
}