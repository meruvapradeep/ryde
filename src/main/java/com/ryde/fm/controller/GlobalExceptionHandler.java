package com.ryde.fm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ryde.fm.domain.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleSQLException(HttpServletRequest request, Exception ex) {

		
		ErrorResponse response = new ErrorResponse();
		response.setErrorCode(HttpStatus.CONFLICT.value());
		response.setErrorMessage(ex.getMessage());

		
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}

}
