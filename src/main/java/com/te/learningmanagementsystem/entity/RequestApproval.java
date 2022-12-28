package com.te.learningmanagementsystem.entity;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

//for show request
@Entity
@Component
public class RequestApproval {
	
	
	
	
	@Id
	private  String employeeId;
	private  String employeeName;
	private  String yop;
	private  String percentage;
	private  String experience;
	private long contactNumber;
	

	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getYop() {
		return yop;
	}
	public void setYop(String list) {
		this.yop = list;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String list) {
		this.experience = list;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public RequestApproval() {
		super();
	}
	
	
	
	

}