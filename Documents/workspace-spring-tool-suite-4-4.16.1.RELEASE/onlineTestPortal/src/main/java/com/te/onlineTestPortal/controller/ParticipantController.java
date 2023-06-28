package com.te.onlineTestPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.onlineTestPortal.dto.ExamCreationDto;
import com.te.onlineTestPortal.response.ScheduleExam;
import com.te.onlineTestPortal.service.AdminService;

@RestController
public class ParticipantController {
	@Autowired
	private AdminService adminService;

	@PostMapping("/SCHEDULEEXAM")
	public ResponseEntity<ScheduleExam> scheduleExam(@RequestBody ExamCreationDto dto) {
		ScheduleExam scheduleExam = adminService.scheduleExam(dto);
		return new ResponseEntity<>(scheduleExam, HttpStatus.CREATED);

	}

}
