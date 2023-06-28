package com.te.allerganlms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.allerganlms.entity.GroupRoles;
@Repository
public interface GroupRepository extends JpaRepository<GroupRoles, Integer>{

}
