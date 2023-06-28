package com.te.onlineTestPortal.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.te.onlineTestPortal.constants.ExamStatus;
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
import com.te.onlineTestPortal.exceptionhandling.CustomException;
import com.te.onlineTestPortal.repository.InstructionRepository;
import com.te.onlineTestPortal.repository.QuestionsRepository;
import com.te.onlineTestPortal.repository.SchedulerRepository;
import com.te.onlineTestPortal.repository.SubjectRepository;
import com.te.onlineTestPortal.response.ScheduleExam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminServiceImp implements AdminService {

	private static final Logger log = LoggerFactory.getLogger(AdminServiceImp.class);

	private final SubjectRepository subjectRepository;
	private final QuestionsRepository questionsRepository;
	private final SchedulerRepository schedulerRepository;
	private final InstructionRepository instructionRepository;

//Subject category CRUD
	@Override
	public SubjectCategory createSubject(SubjectCreationDto creationDto) {
		try {
			String concatId = UUID.randomUUID().toString().substring(0, 3);
			String string = creationDto.getSubjectName().substring(0, 2)
					.concat(creationDto.getCategory().substring(0, 2)).concat(concatId).toUpperCase();
			SubjectCategory category = SubjectCategory.builder().subjectName(creationDto.getSubjectName())
					.category(creationDto.getCategory()).subCode(string).subId(concatId).build();
			return subjectRepository.save(category);

		} catch (CustomException e) {
			e.printStackTrace();
			log.error("unable to save the Subject details", e);
			throw new CustomException("unable to save the Subject details");
		}

	}

	@Override
	public SubjectCategory getSubject(String subCode) {
		try {
			return subjectRepository.findById(subCode)
					.orElseThrow(() -> new CustomException("unable to find the subject with the subject Code"));
		} catch (CustomException e) {
			e.printStackTrace();
			log.error("Please find the Subject code", e);
			throw new CustomException("Please find the Subject code");
		}

	}

	@Override
	public SubjectCategory updateSubject(SubjectUpdationDto updationDto) {
		try {
			SubjectCategory category = subjectRepository.findById(updationDto.getSubCode())
					.orElseThrow(() -> new CustomException("unable to find the subject with the given code"));
			log.error("unable to find the subject with the given code");
			if (updationDto.getCategory().isEmpty()) {
				String string = updationDto.getSubjectName().substring(0, 2)
						.concat(category.getCategory().substring(0, 2)).concat(category.getSubId()).toUpperCase();
				SubjectCategory subjectCategory = SubjectCategory.builder().category(category.getCategory())
						.subjectName(updationDto.getSubjectName()).subId(category.getSubId()).subCode(string).build();
				return subjectRepository.save(subjectCategory);
			} else {
				String string = category.getSubjectName().substring(0, 2).concat(category.getCategory().substring(0, 2))
						.concat(category.getSubId()).toUpperCase();
				SubjectCategory subjectCategory = SubjectCategory.builder().category(updationDto.getCategory())
						.subjectName(category.getSubjectName()).subId(category.getSubId()).subCode(string).build();
				return subjectRepository.save(subjectCategory);
			}
		} catch (CustomException e) {
			e.printStackTrace();
			throw new CustomException("unable to update the given subject data ");

		}

	}

	@Override
	public void deleteSubject(String subCode) {
		try {
			SubjectCategory category = subjectRepository.findById(subCode)
					.orElseThrow(() -> new CustomException("unable to find the subject"));
			subjectRepository.delete(category);

		} catch (CustomException e) {
			log.error("unable to find the subject");
			e.printStackTrace();
		}
	}

//Questions CRUD
	@Override
	public Questions creationQuestions(QuestionsCreationDto creationDto, String subCode) {
		try {
			SubjectCategory category = subjectRepository.findById(subCode)
					.orElseThrow(() -> new CustomException("Unable to fetch the subject from subCode"));
			HashMap<String, String> hashMap = new HashMap<>();
			List<String> answers = creationDto.getAnswers();
			hashMap.put(creationDto.getQuestion(), creationDto.getCorrectAnswer());
			Questions questions = Questions.builder().question(creationDto.getQuestion()).options(answers)
					.subjectCategory(category).correctAnswer(hashMap).build();
			return questionsRepository.save(questions);

		} catch (CustomException e) {
			e.printStackTrace();
			log.error("Unable to create Question");
			throw new CustomException("Unable to create Question");
		}
	}

	@Override
	public Questions fetchQuestions(Integer questionNo) {
		try {
			return questionsRepository.findById(questionNo)
					.orElseThrow(() -> new CustomException("Please enter valid question No"));
		} catch (CustomException e) {
			e.printStackTrace();
			log.error("Unable fetch the Questions Please try after some time");
			throw new CustomException("Unable fetch the Questions Please try after some time");
		}
	}

	@Override
	public Questions updateQuestions(QuestionUpdateDto updateDto) {
		try {
			Questions questions = questionsRepository.findById(updateDto.getQuestionNo())
					.orElseThrow(() -> new CustomException("Please enter the valid Question No"));
			Map<String, String> correctAnswer = questions.getCorrectAnswer();
			List<String> list = updateDto.getAnswers();
			questions.setOptions(list);
			questions.setQuestion(updateDto.getQuestion());
			questions.setCorrectAnswer(correctAnswer);
			return questionsRepository.save(questions);
		} catch (CustomException e) {
			e.printStackTrace();
			throw new CustomException("unable to update the Answers please try again later");
		}
	}

	@Override
	public void deleteQuestions(Integer questionNo) {
		try {
			Questions questions = questionsRepository.findById(questionNo)
					.orElseThrow(() -> new CustomException("Please enter valid Question No"));
			if (questions != null) {
				questions.setSubjectCategory(null);
				questionsRepository.delete(questions);
			} else {
				throw new CustomException("unable to delete the Question");
			}
		} catch (CustomException e) {
			e.printStackTrace();

		}

	}

//	@Override
//	public Map<String, List<String>> fetchQuestions(String subCode) {
//		try {
//			return questionsRepository.findAll().stream()
//					.filter(e -> e.getSubjectCategory().getSubCode().equals(subCode))
//					.collect(Collectors.toMap(Questions::getQuestion, (Questions::getOptions)));
//		} catch (CustomException e) {
//			e.printStackTrace();
//			
//		}
//	}

	@Override
	public Integer checkAnswer(ExamAnswerDto answerDto) {
		try {
			Integer string = questionsRepository.findAll().stream()
					.filter(e -> e.getQuestion().equalsIgnoreCase(answerDto.getQuestion()))
					.mapToInt(Questions::getQuestionNo).sum();
			Questions questions = questionsRepository.findById(string)
					.orElseThrow(() -> new CustomException("unable to find the question"));
			String answer = questions.getCorrectAnswer().get(answerDto.getQuestion());
			if (answer.equalsIgnoreCase(answerDto.getCorrectAnswer()))
				return 1;
			else
				return -1;

		} catch (CustomException e) {
			e.printStackTrace();
		}
		throw new CustomException("unable to find the question please check");

	}

	@Override
	public ExamScheduler addExamSchedule(ExamSchedulerDto schedulerDto) {
		try {
			LocalDateTime date = schedulerDto.getStartDate();
			LocalDateTime endDate = schedulerDto.getEndDate();
			SubjectCategory category = subjectRepository.findById(schedulerDto.getSubCode())
					.orElseThrow(() -> new CustomException("Unable to find the subject"));
			String id = date.getMonth().toString().concat(schedulerDto.getSubCode());
			ExamScheduler scheduler = ExamScheduler.builder().startDate(date).endDate(endDate).schedulerId(id)
					.subjectName(category).build();
			EnumMap<Timing, Integer> enumMap = new EnumMap<>(Timing.class);
			ExamCreationDto creationDto = new ExamCreationDto();
			creationDto.setTime(Timing.SESSIONI);
			Timing time = creationDto.getTime();
//			List<ExamCreationDto> dtos=Arrays.asList(time.getSession(),t)
			System.err.println(time.getSession());
			List<Timing> asList = Arrays.asList(Timing.values());

			for (Timing timing : asList) {
				enumMap.put(timing, 0);
			}
//			scheduler.setNoOfSchedules(enumMap);
			scheduler.setNoOfSchedules(enumMap);
			return schedulerRepository.save(scheduler);
		} catch (CustomException e) {
			e.printStackTrace();
			throw new CustomException("unable to schedule the date for the given subject exams");
		}

	}

	@Override
	public ExamScheduler fetchExamSchedule(String schedulerId) {
		try {
			return schedulerRepository.findById(schedulerId)
					.orElseThrow(() -> new CustomException("unable to find the Scheduled Dates with Id"));
		} catch (CustomException e) {
			e.printStackTrace();
			throw new CustomException("unable to fetch the exams schedule");
		}

	}

	@Override
	public void deleteExamSchedule(String schedulerId) {
		try {
			ExamScheduler scheduler = schedulerRepository.findById(schedulerId)
					.orElseThrow(() -> new CustomException("Unable to find the Schedule Exam"));
			scheduler.setSubjectName(null);
			schedulerRepository.delete(scheduler);
		} catch (CustomException e) {
			e.printStackTrace();
			throw new CustomException("Unable to delete the Exam Schedule");
		}
	}

	@Override
	public List<ExamScheduler> displayExamSchedule() {
		try {
			return schedulerRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Unable to display the List of Exams Scheduled please try after some time");
		}
	}

	@Override
	public List<Instructions> addInstructions(List<String> instructions) {
		try {
			for (String string : instructions) {
				Instructions build = Instructions.builder().instruction(string).build();
				instructionRepository.save(build);
//				if (save!=null)
//					return instructionRepository.findAll();
//				else
//					throw new CustomException("unable to save the instructions");
			}
			return instructionRepository.findAll();
		} catch (CustomException e) {
			e.printStackTrace();
		}
		throw new CustomException("unable to save the instructions");

	}

	@Override
	public List<Instructions> fetchInstructions() {
		try {
			return instructionRepository.findAll();
		} catch (CustomException e) {
			e.printStackTrace();
			throw new CustomException("Unable to find the instructions");
		}
	}

	@Override
	public List<Instructions> updateInstructions(Integer instructionId, String instruction) {
		try {
			Instructions instructions = instructionRepository.findById(instructionId)
					.orElseThrow(() -> new CustomException("unable to find the instruction please check the id"));
			instructions.setInstruction(instruction);
			instructionRepository.save(instructions);
			return instructionRepository.findAll();
		} catch (CustomException e) {
			e.printStackTrace();
		}
		throw new CustomException("unable to update the instruction");

	}

	@Override
	public void deleteInstructions(Integer instructionId) {
		try {
			Instructions instructions = instructionRepository.findById(instructionId)
					.orElseThrow(() -> new CustomException("Unable to find the instruction please check the id"));
			if (instructions != null)
				instructionRepository.delete(instructions);
		} catch (CustomException e) {
			e.printStackTrace();
			throw new CustomException("unable to delete the instruction");
		}
	}

	@Override
	public Map<String, List<String>> questionsList(String subCode) {

		try {

			return questionsRepository.findAll().stream()
					.filter(e -> e.getSubjectCategory().getSubCode().equals(subCode))
					.collect(Collectors.toMap(Questions::getQuestion, Questions::getOptions));
		} catch (CustomException e) {
			e.printStackTrace();
			throw new CustomException("unable to find the questions for the given subCode");
		}
	}

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
