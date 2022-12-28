package com.te.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.te.learningmanagementsystem.entity.RequestApproval;
@Repository
public interface RequestApprovalRepository extends JpaRepository<RequestApproval, String> {

}
