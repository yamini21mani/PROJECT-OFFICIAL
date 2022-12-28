package com.te.learningmanagementsystem.dto;

import org.springframework.stereotype.Component;

@Component
public class MentorUpdateDto {
	
	private String mentorId;
	private String mentorEmailId;
	private String skills;
	private String mentorName;
	
	public String getMentorId() {
		return mentorId;
	}
	public void setMentorId(String mentorId) {
		this.mentorId = mentorId;
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
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

}
