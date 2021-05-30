package com.xyz.mobilehandsetservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.xyz.mobilehandsetservice.errors.ApiError;
import com.xyz.mobilehandsetservice.exception.ApplicationException;

@ControllerAdvice
public class MobileHandsetSearchControllerAdvice {
	@ExceptionHandler({ ApplicationException.class })
	public ResponseEntity<?> handleApplicationException(ApplicationException ex) {
		ApiError apiError = new ApiError();
		apiError.setMessage(ex.getMessage());
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
	}
	
	
}
