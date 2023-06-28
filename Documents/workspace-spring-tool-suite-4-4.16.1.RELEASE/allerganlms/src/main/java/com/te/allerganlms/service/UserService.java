package com.te.allerganlms.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.te.allerganlms.dto.RolesDto;
import com.te.allerganlms.dto.UserCreationDto;
import com.te.allerganlms.entity.Roles;
import com.te.allerganlms.entity.User;
import com.te.allerganlms.entity.UserStatus;

public interface UserService {
	//CREATE API's
	public String createAdminUser(Integer groupId,UserCreationDto userCreationDto);
	public Integer createCommonUser(Integer groupId,UserCreationDto userCreationDto);
	//FETCH API
	public User getUser(Integer employeeId);
	//ADMIN UPDATE API'S
	public User updateEmployeeName(Integer employeeId, String employeeName); 
	public User updateEmployeePassword(Integer employeeId, String employeePassword);
	public User updateUserStatus(Integer employeeId, UserStatus status); 
	//DELETE API
	public void deleteUser(Integer employeeId);
	//Roles API's
	public UserDetails loadUserByUsername(String employeeUserName) throws UsernameNotFoundException;
	public Roles createRole(RolesDto rolesDto);
	public Roles deleteRole(Integer roleId);

}
