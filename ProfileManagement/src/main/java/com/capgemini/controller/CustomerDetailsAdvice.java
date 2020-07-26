package com.capgemini.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.exception.CustomerDetailsException;
import com.capgemini.exception.ErrorInfo;

@RestControllerAdvice
public class CustomerDetailsAdvice {
	
	@ExceptionHandler(value= {CustomerDetailsException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorInfo handleException(Exception ex) {
		return new ErrorInfo(ex.getMessage());
	}
}
