package com.capgemini.exception;

public class CustomerDetailsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomerDetailsException() {
		super();
	}
	
	public CustomerDetailsException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace) {
		super(message , cause , enableSuppression , writableStackTrace);
	}
	
	public CustomerDetailsException(String message , Throwable cause) {
		super(message , cause);
	}
	
	public CustomerDetailsException(String message) {
		super(message);
	}
	
	public CustomerDetailsException(Throwable cause) {
		super(cause);
	}
}
