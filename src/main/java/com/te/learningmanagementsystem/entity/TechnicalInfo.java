package com.te.learningmanagementsystem.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Component
@Entity
@Table
public class TechnicalInfo {

	@Id
//	@Column(unique = true, nullable = false)
	// @Column(name = "Serial Number ")
//	@NotNull
	private Integer sNo;
	// @Column(name = "Skill Type")
//	@NotNull
	private String skillType;
	// @Column(name = "Skill Rating")
//	@NotNull
	private String skillRating;
	// @Column(name = "Years of Experience(over skill)")
//	@NotNull
	private String yearOfExperience;
	// @Column(name = "EmployeeId")
//	@NotNull
//	private String empId;
//	@ManyToOne(cascade = CascadeType.ALL)
//	private Primary_Info primary_Info;

	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}

	public String getSkillType() {
		return skillType;
	}

	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}

	public String getSkillRating() {
		return skillRating;
	}

	public void setSkillRating(String skillRating) {
		this.skillRating = skillRating;
	}

	public String getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(String yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

//	public String getEmpId() {
//		return empId;
//	}
//
//	public void setEmpId(String empId) {
//		this.empId = empId;
//	}

}
