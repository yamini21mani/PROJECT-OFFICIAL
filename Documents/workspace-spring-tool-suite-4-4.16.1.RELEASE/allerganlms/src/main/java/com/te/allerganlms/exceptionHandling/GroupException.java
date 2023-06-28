package com.te.allerganlms.exceptionHandling;

@SuppressWarnings("serial")
public class GroupException extends RuntimeException{
	String message;

	public String getMessage() {
		return message;
	}

	public GroupException(String message) {
		super();
		this.message = message;
	}
	
}
