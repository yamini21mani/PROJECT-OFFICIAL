package com.te.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learningmanagementsystem.entity.EducationalDetails;
@Repository
public interface EducationalRepository extends JpaRepository<EducationalDetails, Integer> {

}
