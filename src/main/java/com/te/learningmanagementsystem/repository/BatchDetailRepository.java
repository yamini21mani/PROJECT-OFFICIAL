package com.te.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learningmanagementsystem.entity.BatchDetails;
@Repository
public interface BatchDetailRepository extends JpaRepository<BatchDetails, String> {

}
