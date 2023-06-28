package com.te.onlineTestPortal.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class SubjectCreationDto {

	private String category;
	private String subjectName;

}
