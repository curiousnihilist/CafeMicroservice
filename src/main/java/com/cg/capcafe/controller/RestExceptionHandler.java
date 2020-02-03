package com.cg.capcafe.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.capcafe.exception.CafeNotFoundException;
import com.cg.capcafe.exception.FoodItemNotFoundException;
import com.cg.capcafe.exception.RestExceptionResponse;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({CafeNotFoundException.class,
					   FoodItemNotFoundException.class})
	public ResponseEntity<RestExceptionResponse> exceptionHandler(Exception ex, WebRequest request){
		
		RestExceptionResponse error = new RestExceptionResponse();
		
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND);
		error.setError(ex.getMessage());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

}
