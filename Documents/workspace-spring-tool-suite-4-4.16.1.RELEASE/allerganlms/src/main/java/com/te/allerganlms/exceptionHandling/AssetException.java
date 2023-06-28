package com.te.allerganlms.exceptionHandling;
@SuppressWarnings("serial")
public class AssetException extends RuntimeException {
	String message;

	public String getMessage() {
		return message;
	}

	public AssetException(String message) {
		super();
		this.message = message;
	}
	

}
