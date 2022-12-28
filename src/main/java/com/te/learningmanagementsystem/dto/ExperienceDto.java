package com.te.learningmanagementsystem.dto;

import org.springframework.stereotype.Component;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Component
public class ExperienceDto {
    
	private Integer sNo;
	
	private String companyName;
	
	private String yearOfExperience;
	
	private String dateOfJoining;

	private String dateOfRelieving;
	
	private String designation;
	
	private String location;
	
	
	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(String yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getDateOfRelieving() {
		return dateOfRelieving;
	}

	public void setDateOfRelieving(String dateOfRelieving) {
		this.dateOfRelieving = dateOfRelieving;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


}
