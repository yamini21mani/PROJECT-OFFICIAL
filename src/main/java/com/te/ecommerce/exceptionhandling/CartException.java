package com.te.ecommerce.exceptionhandling;
@SuppressWarnings("serial")
public class CartException extends RuntimeException{
	
	String message;

	public CartException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


}
