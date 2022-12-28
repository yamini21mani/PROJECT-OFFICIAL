package com.te.learningmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.learningmanagementsystem.entity.AddressInfo;

@Repository
public interface AddressRepository extends JpaRepository<AddressInfo, Integer>{

}
