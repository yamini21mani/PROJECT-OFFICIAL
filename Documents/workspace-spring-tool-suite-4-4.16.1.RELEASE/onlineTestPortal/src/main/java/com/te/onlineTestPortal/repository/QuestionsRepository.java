package com.te.onlineTestPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.onlineTestPortal.entity.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Integer> {

}
