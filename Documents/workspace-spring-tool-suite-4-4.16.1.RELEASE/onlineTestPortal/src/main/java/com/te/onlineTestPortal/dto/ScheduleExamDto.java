package com.te.onlineTestPortal.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.te.onlineTestPortal.entity.ExamLevel;
import com.te.onlineTestPortal.entity.Timing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@RequiredArgsConstructor
public class ScheduleExamDto {
	private String examCode;
	@NotNull(message = "Exam name can't be empty")
	private String examName;
	@NotNull(message = "Exam duration can't be empty")
	private Time duration;
	@NotNull(message = "Exam level can't be empty")
	private ExamLevel level;
	@NotNull(message = "Exam instructions cannot be empty")
	private List<String> instructions;

	@NotNull(message = "Exam date is mandatory")
	private LocalDate date;
	private Timing time;

}
