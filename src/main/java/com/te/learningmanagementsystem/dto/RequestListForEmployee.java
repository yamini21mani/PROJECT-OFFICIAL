package com.te.learningmanagementsystem.dto;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class RequestListForEmployee {

	
	public RequestListForEmployee() {
		super();
	}
	private  String employeeId;
	private  String employeeName;
	private  String yop;
	private  String percentage;
	private  String experience;
	private long contactNumber;
	
	public RequestListForEmployee(String employeeId, String employeeName, String list, String percentage,
			long contactNumber) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.yop = list;
		this.percentage = percentage;
		this.experience = experience;
		this.contactNumber = contactNumber;
	}
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
	public void setYop(String yop) {
		this.yop = yop;
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
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
}
