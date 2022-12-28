package com.te.learningmanagementsystem.entity;

import org.springframework.stereotype.Component;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Component
public class EmployeelistInBatch {
    @Id
	private  String employeeId;
	private  String employeeName;
	private String mockTaken;
	private String mockRating;
	private String attendance;
	private String status;
	
	
	
	
	public EmployeelistInBatch() {
		super();
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
	public String getMockTakenBy() {
		return mockTaken;
	}
	public void setMockTakenBy(String mockTakenBy) {
		this.mockTaken = mockTakenBy;
	}
	public String getMockRating() {
		return mockRating;
	}
	public void setMockRating(String mockRating) {
		this.mockRating = mockRating;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}