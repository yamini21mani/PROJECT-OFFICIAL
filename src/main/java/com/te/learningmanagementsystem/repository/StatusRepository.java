package com.te.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learningmanagementsystem.dto.StatusDto;
@Repository
public interface StatusRepository extends JpaRepository<StatusDto, String> {

}
