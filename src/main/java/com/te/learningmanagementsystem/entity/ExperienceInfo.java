package com.te.learningmanagementsystem.entity;

import org.springframework.stereotype.Component;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Component
@Table
public class ExperienceInfo {
	
	@Id
//	@Column(unique = true, nullable = false)
//	@NotNull
	private Integer sNo;
//	@NotNull
	private String companyName;
//	@NotNull
	private String yearOfExperience;
//	@NotNull
	private String dateOfJoining;
	//@NotBlank(message="Date-Of-Relieving shouldn't be blank")
//	@NotNull
	private String dateOfRelieving;
//	@NotNull
	private String designation;
//	@NotNull
	private String location;
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Primary_Info primary_Info;
	
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
