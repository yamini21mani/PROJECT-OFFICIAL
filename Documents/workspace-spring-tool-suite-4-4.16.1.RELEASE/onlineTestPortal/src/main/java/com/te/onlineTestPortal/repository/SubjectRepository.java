package com.te.onlineTestPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.onlineTestPortal.entity.SubjectCategory;

public interface SubjectRepository extends JpaRepository<SubjectCategory, String> {

}
