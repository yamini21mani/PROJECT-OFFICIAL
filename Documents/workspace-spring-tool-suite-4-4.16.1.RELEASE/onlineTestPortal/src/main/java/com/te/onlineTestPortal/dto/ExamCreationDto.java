package com.te.onlineTestPortal.dto;

import com.te.onlineTestPortal.entity.ExamLevel;
import com.te.onlineTestPortal.entity.Timing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
public class ExamCreationDto {
	private String schedulerId;
	private String subCode;
	private Timing time;
	private ExamLevel level;
	
	
}
