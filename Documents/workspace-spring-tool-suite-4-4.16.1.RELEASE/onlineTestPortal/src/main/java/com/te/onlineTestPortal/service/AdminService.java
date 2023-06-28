package com.te.onlineTestPortal.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.te.onlineTestPortal.dto.ExamAnswerDto;
import com.te.onlineTestPortal.dto.ExamCreationDto;
import com.te.onlineTestPortal.dto.ExamSchedulerDto;
import com.te.onlineTestPortal.dto.QuestionUpdateDto;
import com.te.onlineTestPortal.dto.QuestionsCreationDto;
import com.te.onlineTestPortal.dto.SubjectCreationDto;
import com.te.onlineTestPortal.dto.SubjectUpdationDto;
import com.te.onlineTestPortal.entity.ExamScheduler;
import com.te.onlineTestPortal.entity.Instructions;
import com.te.onlineTestPortal.entity.Questions;
import com.te.onlineTestPortal.entity.SubjectCategory;
import com.te.onlineTestPortal.response.ScheduleExam;

@Service
public interface AdminService {
//Subject CRUD
	public SubjectCategory createSubject(SubjectCreationDto creationDto);

	public SubjectCategory getSubject(String subCode);

	public SubjectCategory updateSubject(SubjectUpdationDto updationDto);

	public void deleteSubject(String subCode);

//Questions CRUD
	public Questions creationQuestions(QuestionsCreationDto creationDto, String subCode);

	public Questions fetchQuestions(Integer questionNo);

	public Questions updateQuestions(QuestionUpdateDto updateDto);

	public void deleteQuestions(Integer questionNo);

	public Integer checkAnswer(ExamAnswerDto answerDto);

	public Map<String, List<String>> questionsList(String subCode);

//Exam Schedule CRUD
	public ExamScheduler addExamSchedule(ExamSchedulerDto schedulerDto);

	public ExamScheduler fetchExamSchedule(String schedulerId);

	public void deleteExamSchedule(String schedulerId);

	public List<ExamScheduler> displayExamSchedule();

	public List<Instructions> addInstructions(List<String> instructions);

	public List<Instructions> fetchInstructions();

	public List<Instructions> updateInstructions(Integer instructionId, String instruction);

	public void deleteInstructions(Integer instructionId);

	public ScheduleExam scheduleExam(ExamCreationDto dto);

}