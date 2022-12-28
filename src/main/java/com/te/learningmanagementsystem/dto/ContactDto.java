package com.te.learningmanagementsystem.dto;

import org.springframework.stereotype.Component;

@Component

public class ContactDto {

	private Long contactNumber;
	
	private String contactType;
	
	
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}


}
