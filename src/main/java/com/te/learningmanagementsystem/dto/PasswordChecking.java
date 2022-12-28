package com.te.learningmanagementsystem.dto;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
@Component
public class PasswordChecking {
	
	private Integer sNo;
	private String empId;
	private String generatedPassword;
	private int count;
	private String firstPassword;
	private String secondPassword;
	
	public Integer getsNo() {
		return sNo;
	}
	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getGeneratedPassword() {
		return generatedPassword;
	}
	public void setGeneratedPassword(String generatedPassword) {
		this.generatedPassword = generatedPassword;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getFirstPassword() {
		return firstPassword;
	}
	public void setFirstPassword(String firstPassword) {
		this.firstPassword = firstPassword;
	}
	public String getSecondPassword() {
		return secondPassword;
	}
	public void setSecondPassword(String secondPassword) {
		this.secondPassword = secondPassword;
	}
}
