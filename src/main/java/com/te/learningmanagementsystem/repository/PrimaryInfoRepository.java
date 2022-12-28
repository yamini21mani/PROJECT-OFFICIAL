package com.te.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learningmanagementsystem.entity.PrimaryInfo;

@Repository
public interface PrimaryInfoRepository extends JpaRepository<PrimaryInfo, String> {

}
