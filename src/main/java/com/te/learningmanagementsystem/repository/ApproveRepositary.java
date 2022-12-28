package com.te.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learningmanagementsystem.entity.ApproveListByAdmin;
@Repository
public interface ApproveRepositary extends JpaRepository<ApproveListByAdmin, String> {

}
