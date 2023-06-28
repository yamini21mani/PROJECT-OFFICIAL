package com.te.onlineTestPortal.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.onlineTestPortal.constants.Messages;
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
import com.te.onlineTestPortal.entity.Timing;
import com.te.onlineTestPortal.response.DisplayExamScheduleResponse;
import com.te.onlineTestPortal.response.DisplayQuestionsResponse;
import com.te.onlineTestPortal.response.InstructionsResponse;
import com.te.onlineTestPortal.response.JreResponse;
import com.te.onlineTestPortal.response.ScheduleExam;
import com.te.onlineTestPortal.service.AdminService;

@RestController
@RequestMapping("/ADMIN")
public class AdminController {

	private static final Logger log = LoggerFactory.getLogger(AdminController.class);

	// Subject CRUD
	@Autowired
	private AdminService adminService;

	@PostMapping("/ADDSUBJECT")
	public ResponseEntity<JreResponse> createSubject(@RequestBody SubjectCreationDto creationDto) {
		SubjectCategory createSubject = adminService.createSubject(creationDto);
		log.info("subject category is created successfully");
		JreResponse jreResponse = JreResponse.builder().data(createSubject).message(Messages.CREATED).error(202)
				.build();
		return new ResponseEntity<>(jreResponse, HttpStatus.CREATED);

	}

	@GetMapping("/FETCHSUBJECT")
	public ResponseEntity<JreResponse> getSubject(@RequestParam String subCode) {
		SubjectCategory createSubject = adminService.getSubject(subCode);
		log.info("subject category is fetched successfully");
		JreResponse jreResponse = JreResponse.builder().data(createSubject).message(Messages.FETCHED).error(302)
				.build();
		return new ResponseEntity<>(jreResponse, HttpStatus.FOUND);

	}

	@PutMapping("/UPDATESUBJECT")
	public ResponseEntity<JreResponse> updateSubject(@RequestBody SubjectUpdationDto updationDto) {
		SubjectCategory createSubject = adminService.updateSubject(updationDto);
		JreResponse jreResponse = JreResponse.builder().data(createSubject).message(Messages.UPDATED).error(202)
				.build();
		log.info("subject category is updated successfully");
		return new ResponseEntity<>(jreResponse, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/DELETESUBJECT")
	public ResponseEntity<JreResponse> deleteSubject(@RequestParam String subCode) {
		adminService.deleteSubject(subCode);
		log.info("subject category is deleted successfully");
		JreResponse jreResponse = JreResponse.builder().message(Messages.DELETED).error(200).build();
		return new ResponseEntity<>(jreResponse, HttpStatus.OK);

	}

//Questions
	@PostMapping("/ADDQUESTION")
	public ResponseEntity<JreResponse> addQuestions(@RequestBody QuestionsCreationDto creationDto,
			@RequestParam String subCode) {
		Questions creationQuestions = adminService.creationQuestions(creationDto, subCode);
		log.info("question is created successfully");
		JreResponse jreResponse = JreResponse.builder().data(creationQuestions).message(Messages.CREATED).error(201)
				.build();
		return new ResponseEntity<>(jreResponse, HttpStatus.CREATED);
	}

	@GetMapping("/FETCHQUESTION")
	public ResponseEntity<JreResponse> fetchQuestions(@RequestParam Integer questionNo) {
		Questions questions = adminService.fetchQuestions(questionNo);
		log.info("question is fetched successfully");
		JreResponse jreResponse = JreResponse.builder().data(questions).message(Messages.FETCHED).error(302).build();
		return new ResponseEntity<>(jreResponse, HttpStatus.FOUND);

	}

	@PutMapping("/UPDATEQUESTION")
	public ResponseEntity<JreResponse> updateQuestions(@RequestBody QuestionUpdateDto updateDto) {
		Questions questions = adminService.updateQuestions(updateDto);
		log.info("question is updated successfully");
		JreResponse jreResponse = JreResponse.builder().data(questions).message(Messages.UPDATED).error(200).build();
		return new ResponseEntity<>(jreResponse, HttpStatus.OK);

	}

	@DeleteMapping("/DELETEQUESTION")
	public ResponseEntity<JreResponse> deleteQuestions(@RequestParam Integer questionNo) {
		adminService.deleteQuestions(questionNo);
		log.info("question is deleted successfully");
		JreResponse jreResponse = JreResponse.builder().error(200).message(Messages.DELETED).build();
		return new ResponseEntity<>(jreResponse, HttpStatus.OK);

	}

	@GetMapping("/questionsList")
	public ResponseEntity<DisplayQuestionsResponse> questionsList(@RequestParam String subCode) {
		Map<String, List<String>> questionsList = adminService.questionsList(subCode);
		log.info("question set is displayed successfully");
		DisplayQuestionsResponse jreResponse = DisplayQuestionsResponse.builder().subCode(subCode)
				.message(Messages.FETCHED).error(302).lists(questionsList).build();
		return new ResponseEntity<>(jreResponse, HttpStatus.FOUND);

	}

	@GetMapping("/checkAnswer")
	public ResponseEntity<JreResponse> checkAnswer(@RequestBody ExamAnswerDto answerDto) {
		Integer checkAnswer = adminService.checkAnswer(answerDto);
		log.info("Answer is verified successfully");
		if (checkAnswer == 1) {
			JreResponse jreResponse = JreResponse.builder().data(checkAnswer).message("Correct Answer").error(302)
					.build();
			return new ResponseEntity<>(jreResponse, HttpStatus.FOUND);

		} else {
			JreResponse jreResponse = JreResponse.builder().data(checkAnswer).message("Incorrect Answer").error(404)
					.build();
			return new ResponseEntity<>(jreResponse, HttpStatus.NOT_FOUND);
		}
	}

//	public ResponseEntity<JreResponse> recordAnswers(@Request)

//EXAM Schedule CRUD's

	@PostMapping({ "/AddExamSchedule", "/UpdateExamSchedule" })
	public ResponseEntity<JreResponse> addExamSchedule(@RequestBody ExamSchedulerDto schedulerDto) {
		ExamScheduler scheduler = adminService.addExamSchedule(schedulerDto);
		log.info("Exam Schedule is modified successfully");
		JreResponse jreResponse = JreResponse.builder().data(scheduler).error(202).message(Messages.CREATED).build();
		return new ResponseEntity<>(jreResponse, HttpStatus.CREATED);
	}

	@GetMapping("/FetchExamSchedule")
	public ResponseEntity<JreResponse> fetchExamSchedule(@RequestParam String schedulerId) {
		ExamScheduler scheduler = adminService.fetchExamSchedule(schedulerId);
		log.info("Exam Schedule is fetched successfully");
		JreResponse jreResponse = JreResponse.builder().data(scheduler).error(302).message(Messages.FETCHED).build();
		return new ResponseEntity<>(jreResponse, HttpStatus.FOUND);
	}

	@DeleteMapping("/deleteExamSchedule")
	public ResponseEntity<JreResponse> deleteExamSchedule(@RequestParam String schedulerId) {
		adminService.deleteExamSchedule(schedulerId);
		log.info("Exam Schedule is deleted successfully");
		JreResponse jreResponse = JreResponse.builder().error(200).message(Messages.DELETED).build();
		return new ResponseEntity<>(jreResponse, HttpStatus.OK);
	}

	@GetMapping("/displayExamSchedule")
	public ResponseEntity<DisplayExamScheduleResponse> displayExamSchedule() {
		List<ExamScheduler> schedule = adminService.displayExamSchedule();
		log.info("Exam Schedule is displayed successfully");
		DisplayExamScheduleResponse response = DisplayExamScheduleResponse.builder().schedulerId(schedule)
				.message(Messages.FETCHED).status(302).build();
		return new ResponseEntity<>(response, HttpStatus.FOUND);
	}

	// Instructions CRUD
	@PostMapping("/addInstructions")
	public ResponseEntity<InstructionsResponse> addInstructions(@RequestParam List<String> instructions) {
		List<Instructions> list = adminService.addInstructions(instructions);
		log.info("Instructions is added successfully");
		InstructionsResponse response = InstructionsResponse.builder().message(Messages.CREATED).rules(list).build();
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/fetchInstructions")
	public ResponseEntity<InstructionsResponse> fetchInstructions() {
		List<Instructions> list = adminService.fetchInstructions();
		log.info("Instructions is fetched successfully");
		InstructionsResponse response = InstructionsResponse.builder().message(Messages.FETCHED).rules(list).build();
		return new ResponseEntity<>(response, HttpStatus.FOUND);
	}

	@PutMapping("/updateInstructions")
	public ResponseEntity<InstructionsResponse> updateInstructions(@RequestParam Integer instructionId,
			@RequestParam String instruction) {
		List<Instructions> list = adminService.updateInstructions(instructionId, instruction);
		log.info("Instructions is deleted successfully");
		InstructionsResponse response = InstructionsResponse.builder().message(Messages.UPDATED).rules(list).build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping("/deleteInstructions")
	public ResponseEntity<JreResponse> deleteInstructions(@RequestParam Integer instructionId) {
		adminService.deleteInstructions(instructionId);
		log.info("Instructions is deleted successfully");
		JreResponse response = JreResponse.builder().message(Messages.DELETED).build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/EXAMTIMINGS")
	public ResponseEntity<JreResponse> displayExamTimings() {
		List<Timing> list = Arrays.asList(Timing.values());
		JreResponse response = JreResponse.builder().data(list).message(Messages.FETCHED).build();
		return new ResponseEntity<>(response, HttpStatus.FOUND);
	}

	@PostMapping("/SCHEDULEEXAM")
	public ResponseEntity<ScheduleExam> scheduleExam(@RequestBody ExamCreationDto dto) {
		ScheduleExam scheduleExam = adminService.scheduleExam(dto);
		return new ResponseEntity<>(scheduleExam, HttpStatus.CREATED);

	}

}
