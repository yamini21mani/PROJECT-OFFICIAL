package com.te.ecommerce.exceptionhandling;

@SuppressWarnings("serial")
public class GeneralException extends RuntimeException {
	String message;

	public GeneralException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
