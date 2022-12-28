package com.te.learningmanagementsystem.dto;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDto {
	private String empId;
	private String empPass;

	public String getEmpPass() {
		return empPass;
	}

	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
