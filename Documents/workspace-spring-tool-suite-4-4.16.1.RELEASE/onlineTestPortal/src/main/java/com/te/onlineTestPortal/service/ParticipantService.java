package com.te.onlineTestPortal.service;

import com.te.onlineTestPortal.dto.ExamCreationDto;
import com.te.onlineTestPortal.response.ScheduleExam;

public interface ParticipantService {
	public ScheduleExam scheduleExam(ExamCreationDto dto);

}
