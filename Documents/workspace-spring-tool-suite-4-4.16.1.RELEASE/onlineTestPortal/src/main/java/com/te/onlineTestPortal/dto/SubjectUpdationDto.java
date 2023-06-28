package com.te.onlineTestPortal.dto;

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
public class SubjectUpdationDto {

	private String subCode;
	private String category;
	private String subjectName;
}
