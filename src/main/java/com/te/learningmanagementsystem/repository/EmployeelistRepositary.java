package com.te.learningmanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learningmanagementsystem.entity.EmployeelistInBatch;
@Repository
public interface EmployeelistRepositary extends JpaRepository<EmployeelistInBatch, String> {

	//List<EmployeelistInBatch> findALL(String employeeId);
}
