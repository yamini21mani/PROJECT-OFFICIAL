package com.te.allerganlms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.allerganlms.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{


	User findUserByemployeeUserName(String employeeUserName);

}
