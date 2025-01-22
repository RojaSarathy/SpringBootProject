package com.example.spring.swagger.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {
     
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handelException(IllegalArgumentException e){
		
		return new ResponseEntity<Object>("Illegal Argument Exception In Global ", HttpStatus.BAD_REQUEST);
	}
}
