package com.te.allerganlms.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class QuizCreationDto {
	private String quizName;
	private String quizMarks;
	private String quizStatus;
	private Integer quizAttempts;

}
