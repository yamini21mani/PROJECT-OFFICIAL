package com.te.ecommerce.exceptionhandling;
@SuppressWarnings("serial")
public class CredentialsException extends RuntimeException {
	
	String message;

	public CredentialsException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	

}
