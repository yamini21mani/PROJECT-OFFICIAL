package com.te.onlineTestPortal.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.te.onlineTestPortal.constants.ExamStatus;
import com.te.onlineTestPortal.dto.ExamCreationDto;
import com.te.onlineTestPortal.entity.ExamScheduler;
import com.te.onlineTestPortal.entity.Timing;
import com.te.onlineTestPortal.exceptionhandling.CustomException;
import com.te.onlineTestPortal.repository.SchedulerRepository;
import com.te.onlineTestPortal.response.ScheduleExam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ParticipantServiceImp implements ParticipantService {

	private final SchedulerRepository schedulerRepository;

	@Override
	public ScheduleExam scheduleExam(ExamCreationDto dto) {

		try {
			ScheduleExam response = new ScheduleExam();
			response.setLevel(dto.getLevel());
			response.setSubCode(dto.getSubCode());
			response.setTime(dto.getTime());
			response.setSchedulerId(dto.getSchedulerId());
			response.setStatus(ExamStatus.SCHEDULED);
			ExamScheduler examScheduler = schedulerRepository.findById(dto.getSchedulerId())
					.orElseThrow(() -> new CustomException("unable to find the  schedule"));
			Map<Timing, Integer> noOfSchedules = examScheduler.getNoOfSchedules();
			noOfSchedules.put(dto.getTime(), noOfSchedules.get(dto.getTime()) + 1);
			examScheduler.setNoOfSchedules(noOfSchedules);
			schedulerRepository.save(examScheduler);
			return response;
		} catch (CustomException e) {
			e.printStackTrace();
		}
		throw new CustomException("slot is full, please try in next slot");

	}
}
