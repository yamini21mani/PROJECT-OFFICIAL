package com.te.onlineTestPortal.dto;

import java.util.List;

import lombok.Data;
@Data
public class QuestionUpdateDto {
	private Integer questionNo;
	private String question;
	private List<String> answers;
	private String correctAnswer;
}
