package com.te.learningmanagementsystem.entity;

import org.springframework.stereotype.Component;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Component
@Table
public class EducationalDetails {

//	private String empId;
	@Id
//	@Column(unique = true, nullable = false)
//	@NotNull
//	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sNo;
//	@NotNull
//	private String educationDetailsId;
//	@NotNull
	private String educationType;
//	@NotNull
	private String percentage;
//	@NotNull
	private String instituteName;
//	@NotNull
	private String state;
//	@NotNull
	private String yearOfPassing;
//	@NotNull
	private String universityName;
//	@NotNull
	private String specialization;
	
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Primary_Info primary_Info;
	
	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}

	public String getEducationType() {
		return educationType;
	}

	public void setEducationType(String string) {
		this.educationType = string;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(String string) {
		this.yearOfPassing = string;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

//	public String getEmpId() {
//		return empId;
//	}
//
//	public void setEmpId(String empId) {
//		this.empId = empId;
//	}
//
//	public String getEducationDetailsId() {
//		return educationDetailsId;
//	}
//
//	public void setEducationDetailsId(String educationDetailsId) {
//		this.educationDetailsId = educationDetailsId;
//	}

}
