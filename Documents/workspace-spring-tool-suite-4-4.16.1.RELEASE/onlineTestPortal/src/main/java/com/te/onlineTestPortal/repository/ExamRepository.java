package com.te.onlineTestPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.onlineTestPortal.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, String> {

}
