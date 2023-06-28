package com.te.onlineTestPortal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.te.onlineTestPortal.constants.Messages;
import com.te.onlineTestPortal.dto.ExamAnswerDto;
import com.te.onlineTestPortal.dto.ExamSchedulerDto;
import com.te.onlineTestPortal.dto.QuestionUpdateDto;
import com.te.onlineTestPortal.dto.QuestionsCreationDto;
import com.te.onlineTestPortal.dto.SubjectCreationDto;
import com.te.onlineTestPortal.dto.SubjectUpdationDto;
import com.te.onlineTestPortal.entity.ExamScheduler;
import com.te.onlineTestPortal.entity.Instructions;
import com.te.onlineTestPortal.entity.Questions;
import com.te.onlineTestPortal.entity.SubjectCategory;
import com.te.onlineTestPortal.response.DisplayExamScheduleResponse;
import com.te.onlineTestPortal.response.DisplayQuestionsResponse;
import com.te.onlineTestPortal.response.InstructionsResponse;
import com.te.onlineTestPortal.response.JreResponse;
import com.te.onlineTestPortal.service.AdminService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AdminControllerTest {
	@MockBean
	private AdminService adminService;
//	@Autowired
//	private WebApplicationContext context;
//	@Autowired
//	private MockMvc mockMvc;
//	@Autowired
//	private ObjectMapper mapper;
	@InjectMocks
	AdminController adminController;

//	@BeforeEach
//	public void setup() {
//		MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//
//	}

	@Test
	void createSubjectTest() throws Exception {
		SubjectCreationDto creationDto = SubjectCreationDto.builder().category("Java").subjectName("Core Java").build();
		SubjectCategory category = SubjectCategory.builder().category(creationDto.getCategory()).subCode("java01j")
				.subId("1l").subjectName(creationDto.getSubjectName()).build();
		when(adminService.createSubject(creationDto)).thenReturn(category);
		ResponseEntity<JreResponse> createSubject = adminController.createSubject(creationDto);
		assertEquals(HttpStatus.CREATED, createSubject.getStatusCode());
		JreResponse response = createSubject.getBody();
		assertEquals(category, response.getData());
		assertEquals(Messages.CREATED, response.getMessage());
		assertEquals(202, response.getError());

//		ResultActions andExpect = mockMvc.perform(MockMvcRequestBuilders.post("/ADMIN/ADDSUBJECT")).andExpect(status().isCreated()).andExpect(contentType(MediaType.APPLICATION_JSON)).andExpect(json);

	}

	@Test
	void getSubjectTest() throws Exception {
		SubjectCategory category = SubjectCategory.builder().category("Java").subCode("java01j").subId("1l")
				.subjectName("Core Java").build();
		when(adminService.getSubject("1l")).thenReturn(category);
		ResponseEntity<JreResponse> subject = adminController.getSubject("1l");
		assertEquals(HttpStatus.FOUND, subject.getStatusCode());
		JreResponse jreResponse = subject.getBody();
		assertEquals(302, jreResponse.getError());
		assertEquals(category, jreResponse.getData());
		assertEquals(Messages.FETCHED, jreResponse.getMessage());
	}

	@Test
	void updateSubjectTest() throws Exception {
		SubjectUpdationDto dto = SubjectUpdationDto.builder().subCode("1").category("Java").subjectName("Core Java")
				.build();
		SubjectCategory category = SubjectCategory.builder().category("Java").subCode("1").subId("1l")
				.subjectName("Core Java").build();
		when(adminService.updateSubject(dto)).thenReturn(category);
		ResponseEntity<JreResponse> updateSubject = adminController.updateSubject(dto);
		assertEquals(HttpStatus.ACCEPTED, updateSubject.getStatusCode());
		assertEquals(category, updateSubject.getBody().getData());
		assertEquals(Messages.UPDATED, updateSubject.getBody().getMessage());
		assertEquals(202, updateSubject.getBody().getError());

	}

	@Test
	void deleteSubjectTest() throws Exception {
		String subCode = "1111";
		ResponseEntity<JreResponse> deleteSubject = adminController.deleteSubject(subCode);
		assertEquals(Messages.DELETED, deleteSubject.getBody().getMessage());
		assertEquals(HttpStatus.OK, deleteSubject.getStatusCode());
		assertEquals(200, deleteSubject.getBody().getError());
		assertNull(deleteSubject.getBody().getData());

	}

	@Test
	void addQuestionTest() throws Exception {
		SubjectCategory category = SubjectCategory.builder().subCode("1").subId("1").category("Java")
				.subjectName("Core java").build();
		List<String> stringList = new ArrayList<>();
		stringList.add("1");
		stringList.add("1");
		stringList.add("1");
		stringList.add("1");
		QuestionsCreationDto creationDto = QuestionsCreationDto.builder().question("1l").answers(stringList)
				.correctAnswer("1").build();
		Map<String, String> map = new HashMap<>();
		map.put("1l", "1l");
		Questions questions = Questions.builder().question("1l").options(stringList).correctAnswer(map).questionNo(1)
				.subjectCategory(category).build();
		when(adminService.creationQuestions(creationDto, "1")).thenReturn(questions);
		ResponseEntity<JreResponse> addQuestions = adminController.addQuestions(creationDto, "1");
		assertEquals(HttpStatus.CREATED, addQuestions.getStatusCode());
		JreResponse jreResponse = addQuestions.getBody();
		assertEquals(202, jreResponse.getError());
		assertEquals(Messages.CREATED, jreResponse.getMessage());
		assertEquals(questions, jreResponse.getData());

	}

	@Test
	void fetchQuestionsTest() throws Exception {
		Integer questionNo = 1;
		Questions questions = new Questions();
		questions.setQuestionNo(1);
		when(adminService.fetchQuestions(questionNo)).thenReturn(questions);
		ResponseEntity<JreResponse> fetchQuestions = adminController.fetchQuestions(questionNo);
		assertEquals(questions, fetchQuestions.getBody().getData());
		assertEquals(Messages.FETCHED, fetchQuestions.getBody().getMessage());
		assertEquals(302, fetchQuestions.getBody().getError());
		assertEquals(HttpStatus.FOUND, fetchQuestions.getStatusCode());
	}

	@Test
	void updateQuestionsTest() throws Exception {
		QuestionUpdateDto dto = new QuestionUpdateDto();
		dto.setQuestion("1");
		dto.setQuestionNo(1);
		dto.setCorrectAnswer("1");
		dto.setAnswers(Arrays.asList("1", "1", "1", "1"));
		Questions questions = new Questions();
		when(adminService.updateQuestions(dto)).thenReturn(questions);
		ResponseEntity<JreResponse> updateQuestions = adminController.updateQuestions(dto);
		assertEquals(questions, updateQuestions.getBody().getData());
		assertEquals(HttpStatus.OK, updateQuestions.getStatusCode());
		assertEquals(Messages.UPDATED, updateQuestions.getBody().getMessage());
		assertEquals(200, updateQuestions.getBody().getError());

	}

	@Test
	void deleteQuestionsTest() throws Exception {
		Integer questionNo = 1;
		ResponseEntity<JreResponse> deleteQuestions = adminController.deleteQuestions(questionNo);
		assertNull(deleteQuestions.getBody().getData());
	}

//	@Test
//	void fetchQuestionsOnSubcode() throws Exception {
//		String subCode = "1111";
//		Map<String, List<String>> list = new HashMap<>();
//		when(adminService.questionsList(subCode)).thenReturn(list);
//		ResponseEntity<DisplayQuestionsResponse> fetchQuestions = adminController.fetchQuestions(subCode);
//		assertEquals(list, fetchQuestions.getBody().getData());
//		assertEquals(Messages.FETCHED, fetchQuestions.getBody().getMessage());
//		assertEquals(subCode, fetchQuestions.getBody().getSubCode());
//	}

	@Test
	void questionsList() throws Exception {
		String subCode = "1111";
		Map<String, List<String>> map = new HashMap<>();
		when(adminService.questionsList(subCode)).thenReturn(map);
		ResponseEntity<DisplayQuestionsResponse> questionsList = adminController.questionsList(subCode);
		assertNotNull(questionsList);
	}

	@Test
	void checkCorrectAnswerTest() throws Exception {
		ExamAnswerDto dto = new ExamAnswerDto();
		when(adminService.checkAnswer(dto)).thenReturn(1);
		ResponseEntity<JreResponse> checkAnswer = adminController.checkAnswer(dto);
		assertNotNull(checkAnswer.getBody().getData());
	}

	@Test
	void checkWrongAnswerTest() throws Exception {
		ExamAnswerDto dto = new ExamAnswerDto();
		when(adminService.checkAnswer(dto)).thenReturn(-1);
		ResponseEntity<JreResponse> checkAnswer = adminController.checkAnswer(dto);
		assertNotNull(checkAnswer.getBody().getData());
	}

	@Test
	void addExamDateTest() throws Exception {
		ExamSchedulerDto dto = new ExamSchedulerDto();
		ExamScheduler scheduler = new ExamScheduler();
		when(adminService.addExamSchedule(dto)).thenReturn(scheduler);
		ResponseEntity<JreResponse> addExamDate = adminController.addExamSchedule(dto);
		assertNotNull(addExamDate);
	}

	@Test
	void fetchExamDateTest() throws Exception {
		String schedulerId = "1l";
		ExamScheduler scheduler = new ExamScheduler();
		when(adminService.fetchExamSchedule(schedulerId)).thenReturn(scheduler);
		ResponseEntity<JreResponse> fetchExamDate = adminController.fetchExamSchedule(schedulerId);
		assertNotNull(fetchExamDate);
	}

	@Test
	void deleteExamDateTest() throws Exception {
		String schedulerId = "1l";
		ResponseEntity<JreResponse> deleteExamDate = adminController.deleteExamSchedule(schedulerId);
		assertNull(deleteExamDate.getBody().getData());
	}

	@Test
	void displayExamScheduleTest() throws Exception {
		List<ExamScheduler> list = new ArrayList<>();
		when(adminService.displayExamSchedule()).thenReturn(list);
		ResponseEntity<DisplayExamScheduleResponse> displayExamSchedule = adminController.displayExamSchedule();
		assertEquals(list, displayExamSchedule.getBody().getSchedulerId());

	}

	@Test
	void addInstructionsTest() throws Exception {
		List<String> list = new ArrayList<>();
		List<Instructions> instructions = new ArrayList<>();
		when(adminService.addInstructions(list)).thenReturn(instructions);
		ResponseEntity<InstructionsResponse> addInstructions = adminController.addInstructions(list);
		assertEquals(instructions, addInstructions.getBody().getRules());

	}

	@Test
	void fetchInstructionsTest() throws Exception {
		List<Instructions> instructions = new ArrayList<>();
		when(adminService.fetchInstructions()).thenReturn(instructions);
		ResponseEntity<InstructionsResponse> addInstructions = adminController.fetchInstructions();
		assertEquals(instructions, addInstructions.getBody().getRules());

	}

	@Test
	void updateInstructionsTest() throws Exception {
		Integer instructionId = 1;
		String instruction = "111";
		List<Instructions> instructions = new ArrayList<>();
		when(adminService.updateInstructions(instructionId, instruction)).thenReturn(instructions);
		ResponseEntity<InstructionsResponse> addInstructions = adminController.updateInstructions(instructionId,
				instruction);
		assertEquals(instructions, addInstructions.getBody().getRules());

	}

	@Test
	void deleteInstructionsTest() throws Exception {
		Integer instructionId = 1;
		ResponseEntity<JreResponse> addInstructions = adminController.deleteInstructions(instructionId);
		assertNull(addInstructions.getBody().getData());
	}

}
