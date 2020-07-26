package com.capgemini.exception;

public class ProfileException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProfileException() {
		super();
	}
	
	public ProfileException(String message,Throwable cause,boolean enableSuppression,boolean writableStackTrace) {
		super(message , cause , enableSuppression , writableStackTrace);
	}
	
	public ProfileException(String message , Throwable cause) {
		super(message , cause);
	}
	
	public ProfileException(String message) {
		super(message);
	}
	
	public ProfileException(Throwable cause) {
		super(cause);
	}
}