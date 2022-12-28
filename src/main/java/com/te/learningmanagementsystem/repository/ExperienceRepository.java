package com.te.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learningmanagementsystem.entity.ExperienceInfo;

@Repository
public interface ExperienceRepository extends JpaRepository<ExperienceInfo, Integer>{

}
