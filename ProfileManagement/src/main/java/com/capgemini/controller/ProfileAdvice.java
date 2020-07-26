package com.capgemini.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.exception.ErrorInfo;
import com.capgemini.exception.ProfileException;

@RestControllerAdvice
public class ProfileAdvice {
	@ExceptionHandler(value = {ProfileException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorInfo handleException(Exception ex) {
		return new ErrorInfo(ex.getMessage());
	}
}
