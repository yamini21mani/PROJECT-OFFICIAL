package com.te.onlineTestPortal.response;

import java.util.List;
import java.util.Map;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.te.onlineTestPortal.entity.ExamLevel;
import com.te.onlineTestPortal.entity.ExamScheduler;
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
public class DisplayExamScheduleResponse {

	private List<ExamScheduler> schedulerId;
	private String subCode;
	private String message;
	private Integer status;
	@Enumerated(EnumType.STRING)
	private ExamLevel level;
	private Timing time;
	private Map<String, List<String>> questions;

}
