package com.te.onlineTestPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.onlineTestPortal.entity.ExamScheduler;

public interface SchedulerRepository extends JpaRepository<ExamScheduler, String> {

}
