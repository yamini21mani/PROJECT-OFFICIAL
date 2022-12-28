package com.te.learningmanagementsystem.dto;

import org.springframework.stereotype.Component;

@Component
public class AdminShowRequestDto {

	private  String employeeId;
	private  String employeeName;
	private  String yop;
	private  String percentage;
	private  String experience;
	private long contactNumber;
	private String empBatchId;
	private String empBatchName;
	
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
	public String getEmpBatchId() {
		return empBatchId;
	}
	public void setEmpBatchId(String empBatchId) {
		this.empBatchId = empBatchId;
	}
	public String getEmpBatchName() {
		return empBatchName;
	}
	public void setEmpBatchName(String empBatchName) {
		this.empBatchName = empBatchName;
	}
}
