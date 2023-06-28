package com.te.onlineTestPortal.response;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.te.onlineTestPortal.constants.ExamStatus;
import com.te.onlineTestPortal.entity.ExamLevel;
import com.te.onlineTestPortal.entity.Timing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class ScheduleExam {
	@Id
	private String schedulerId;
	private String subCode;
	@Enumerated(EnumType.STRING)
	private ExamStatus status;
	@Enumerated(EnumType.STRING)
	private ExamLevel level;
	@Enumerated(EnumType.STRING)
	private Timing time;
}
