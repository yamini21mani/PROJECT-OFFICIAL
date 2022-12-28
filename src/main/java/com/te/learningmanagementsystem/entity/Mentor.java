package com.te.learningmanagementsystem.entity;

import org.springframework.stereotype.Component;


//import jakarta.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Component
@Table
public class Mentor {
	
//	@NotNull
	private String mentorName;
	@Id
	private Integer mentorId;
public Integer getMentorId() {
		return mentorId;
	}
	public void setMentorId(Integer mentorId) {
		this.mentorId = mentorId;
	}
	//	@NotNull
	private String mentorEmailId;
//	@NotNull
	private String skills;
	
	
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	
	public String getMentorEmailId() {
		return mentorEmailId;
	}
	public void setMentorEmailId(String mentorEmailId) {
		this.mentorEmailId = mentorEmailId;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
}
