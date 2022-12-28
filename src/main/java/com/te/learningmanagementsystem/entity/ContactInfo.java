package com.te.learningmanagementsystem.entity;

import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Component
@Table
public class ContactInfo {
	@Id
//	@NotNull
	private Long contactNumber;
//	@NotNull
	private String contactType;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Primary_Info primary_Info;
	
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
