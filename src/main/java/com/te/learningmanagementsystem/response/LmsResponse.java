package com.te.learningmanagementsystem.response;

import org.springframework.stereotype.Component;

@Component
public class LmsResponse {
	private String message;
	private boolean error;
	private String status;
	private Object data;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean getError() {
		return error;
	}
	public void setError(boolean i) {
		this.error = i;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

}
