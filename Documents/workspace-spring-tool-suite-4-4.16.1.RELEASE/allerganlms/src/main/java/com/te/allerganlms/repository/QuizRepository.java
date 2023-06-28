package com.te.allerganlms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.allerganlms.entity.Quiz;
@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{

}
