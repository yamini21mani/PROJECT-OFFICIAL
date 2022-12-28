package com.te.learningmanagementsystem.dto;

import org.springframework.stereotype.Component;

@Component
public class BatchDetailsDto {
	private Integer sNo;
	private String empBatchId;
	private String empBatchName;
	private String empMentorName;
	private String empTechnologies;
	private String empStartDate;
	private String empEndDate;
	private String empStatus;
	private String empAction;
	private String empBatchStrength;
	
	public Integer getsNo() {
		return sNo;
	}
	public void setsNo(Integer sNo) {
		this.sNo = sNo;
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
	public String getEmpMentorName() {
		return empMentorName;
	}
	public void setEmpMentorName(String empMentorName) {
		this.empMentorName = empMentorName;
	}
	public String getEmpTechnologies() {
		return empTechnologies;
	}
	public void setEmpTechnologies(String empTechnologies) {
		this.empTechnologies = empTechnologies;
	}
	public String getEmpStartDate() {
		return empStartDate;
	}
	public void setEmpStartDate(String empStartDate) {
		this.empStartDate = empStartDate;
	}
	public String getEmpEndDate() {
		return empEndDate;
	}
	public void setEmpEndDate(String empEndDate) {
		this.empEndDate = empEndDate;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public String getEmpAction() {
		return empAction;
	}
	public void setEmpAction(String empAction) {
		this.empAction = empAction;
	}
	public String getEmpBatchStrength() {
		return empBatchStrength;
	}
	public void setEmpBatchStrength(String empBatchStrength) {
		this.empBatchStrength = empBatchStrength;
	}


	
	
	
	
	
}
