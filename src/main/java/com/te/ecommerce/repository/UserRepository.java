package com.te.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.ecommerce.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
