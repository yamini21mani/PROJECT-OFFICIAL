package com.te.allerganlms.exceptionHandling;
@SuppressWarnings("serial")
public class QuizException extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public QuizException(String message) {
		super();
		this.message = message;
	}

}
