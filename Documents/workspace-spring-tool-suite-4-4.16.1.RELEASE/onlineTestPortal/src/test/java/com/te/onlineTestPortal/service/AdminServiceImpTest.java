package com.te.onlineTestPortal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.te.onlineTestPortal.dto.QuestionUpdateDto;
import com.te.onlineTestPortal.dto.QuestionsCreationDto;
import com.te.onlineTestPortal.dto.SubjectCreationDto;
import com.te.onlineTestPortal.dto.SubjectUpdationDto;
import com.te.onlineTestPortal.entity.Questions;
import com.te.onlineTestPortal.entity.SubjectCategory;
import com.te.onlineTestPortal.exceptionhandling.CustomException;
import com.te.onlineTestPortal.repository.QuestionsRepository;
import com.te.onlineTestPortal.repository.SubjectRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AdminServiceImpTest {
	@InjectMocks
	private AdminServiceImp adminService;
	@Mock
	SubjectRepository subjectRepository;
	@Mock
	QuestionsRepository questionsRepository;

	@Test
	void createSubjectTest() {
		SubjectCreationDto creationDto = new SubjectCreationDto("111", "111");
		String concatId = UUID.randomUUID().toString().substring(0, 3);
		String string = creationDto.getSubjectName().substring(0, 2).concat(creationDto.getCategory().substring(0, 2))
				.concat(concatId).toUpperCase();
		SubjectCategory category = new SubjectCategory(string, "1111", "111", "111");
		when(subjectRepository.save(any(SubjectCategory.class))).thenReturn(category);
		SubjectCategory createSubject = adminService.createSubject(creationDto);
		assertEquals(category, createSubject);

	}

	@Test
	void createSubjectExceptionTest() {
		SubjectCreationDto creationDto = new SubjectCreationDto("111", "111");
		when(subjectRepository.save(any(SubjectCategory.class))).thenThrow(new CustomException());
		assertThrows(CustomException.class, () -> adminService.createSubject(creationDto));

	}

	@Test
	void getSubjectTest() {
		SubjectCategory category = new SubjectCategory();
		when(subjectRepository.findById(anyString())).thenReturn(Optional.of(category));
		SubjectCategory subject = adminService.getSubject("code");
		assertEquals(category, subject);
	}

	@Test
	void getSubjectExceptionTest() {
		when(subjectRepository.findById("1")).thenReturn(Optional.empty());
		assertEquals(CustomException.class,
				assertThrows(CustomException.class, () -> adminService.getSubject("1")).getClass());
	}

	@Test
	void updateSubjectIfTest() {
		SubjectUpdationDto dto = new SubjectUpdationDto("1111", "", "1111");
		SubjectCategory category = new SubjectCategory("1111", "111", "1111", "111");
		when(subjectRepository.findById("1111")).thenReturn(Optional.of(category));
		when(subjectRepository.save(any())).thenReturn(category);
		SubjectCategory updateSubject = adminService.updateSubject(dto);
		assertNotNull(updateSubject);

	}

	@Test
	void updateSubjectElseTest() {
		SubjectUpdationDto dto=new SubjectUpdationDto("1111", "1111", "");
		SubjectCategory category = new SubjectCategory("1111", "111", "1111", "111");
		when(subjectRepository.findById("1111")).thenReturn(Optional.of(category));
		when(subjectRepository.save(any())).thenReturn(category);
		SubjectCategory updateSubject = adminService.updateSubject(dto);
		assertNotNull(updateSubject);
	}
	@Test
	void updateSubjectExceptionTest() {
		SubjectUpdationDto dto=new SubjectUpdationDto();
		lenient().when(subjectRepository.save(any())).thenThrow(new CustomException("unable to update the given subject data "));
		assertThrows(CustomException.class, () -> adminService.updateSubject(dto));
	}

	@Test
	void deleteSubjectTest() {

		when(subjectRepository.findById(anyString())).thenReturn(Optional.of(new SubjectCategory()));
		adminService.deleteSubject("code");
	}

	@Test
	void deleteSubjectExceptionTest() {

		adminService.deleteSubject(null);
	}

	@Test
	void creationQuestionsTest() {
		List<String> asList = Arrays.asList("a", "a", "a", "a");
		when(subjectRepository.findById(anyString())).thenReturn(Optional.of(new SubjectCategory()));
		QuestionsCreationDto dto = new QuestionsCreationDto("1", asList, "1");
		when(questionsRepository.save(any())).thenReturn(new Questions());
		Questions creationQuestions = adminService.creationQuestions(dto, "code");
		assertNotNull(creationQuestions);
	}

	@Test
	void creationQuestionsExceptionTest() {
		QuestionsCreationDto creationDto = new QuestionsCreationDto();
		lenient().when(questionsRepository.save(any())).thenThrow(new CustomException("Unable to create Question"));
		assertThrows(CustomException.class, () -> adminService.creationQuestions(creationDto, "code"));
	}

	@Test
	void fetchQuestionsTest() {
		Integer questionNo = 1;
		when(questionsRepository.findById(questionNo)).thenReturn(Optional.of(new Questions()));
		Questions fetchQuestions = adminService.fetchQuestions(1);
		assertNotNull(fetchQuestions);

	}

	@Test
	void fetchQuestionsExceptionTest() {
		lenient().when(questionsRepository.findById(null))
				.thenThrow(new CustomException("Unable fetch the Questions Please try after some time"));
		assertThrows(CustomException.class, () -> adminService.fetchQuestions(1));
	}

	@Test
	void updateQuestionsTest() {
		QuestionUpdateDto dto = new QuestionUpdateDto();
		dto.setQuestionNo(1);
		Questions questions = new Questions();
		lenient().when(questionsRepository.findById(dto.getQuestionNo())).thenReturn(Optional.of(questions));
		List<String> list = Arrays.asList("1", "1", "1", "1");
		questions.setOptions(list);
		questions.setQuestion("1");
		HashMap<String, String> map = new HashMap<>();
		map.put("1", "1");
		questions.setCorrectAnswer(map);
		lenient().when(questionsRepository.save(any(Questions.class))).thenReturn(questions);
		Questions updateQuestions = adminService.updateQuestions(dto);
		assertNotNull(updateQuestions);
	}

	@Test
	void updateQuestionsExceptionTest() {
		QuestionUpdateDto dto = new QuestionUpdateDto();
		dto.setQuestionNo(1);
		when(questionsRepository.findById(dto.getQuestionNo()))
				.thenThrow(new CustomException("unable to update the Answers please try again later"));
		assertThrows(CustomException.class, () -> adminService.updateQuestions(dto));
	}

}
