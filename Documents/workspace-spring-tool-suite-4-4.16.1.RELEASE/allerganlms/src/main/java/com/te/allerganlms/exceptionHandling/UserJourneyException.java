package com.te.allerganlms.exceptionHandling;

@SuppressWarnings("serial")
public class UserJourneyException extends RuntimeException{
	String message;

	public String getMessage() {
		return message;
	}

	public UserJourneyException(String message) {
		super();
		this.message = message;
	}
}
