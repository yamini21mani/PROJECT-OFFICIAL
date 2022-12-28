package com.te.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.learningmanagementsystem.entity.TechnicalInfo;

public interface TechnicalRepository extends JpaRepository<TechnicalInfo, Integer> {

}
