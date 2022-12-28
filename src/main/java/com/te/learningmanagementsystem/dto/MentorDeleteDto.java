package com.te.learningmanagementsystem.dto;

import org.springframework.stereotype.Component;

@Component
public class MentorDeleteDto {
	
	private String mentorId;
	
	public String getMentorId() {
		return mentorId;
	}

	public void setMentorId(String mentorId) {
		this.mentorId = mentorId;
	}

}
