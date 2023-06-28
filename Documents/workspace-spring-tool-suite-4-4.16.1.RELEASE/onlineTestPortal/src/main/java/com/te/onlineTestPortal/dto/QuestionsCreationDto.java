package com.te.onlineTestPortal.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Component
public class QuestionsCreationDto {
	private String question;
	private List<String> answers;
	private String correctAnswer;
}
