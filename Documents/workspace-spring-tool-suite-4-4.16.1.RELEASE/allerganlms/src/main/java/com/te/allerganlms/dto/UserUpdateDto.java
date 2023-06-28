package com.te.allerganlms.dto;

import org.springframework.stereotype.Component;

import com.te.allerganlms.entity.Roles;
import com.te.allerganlms.entity.UserStatus;

import lombok.Data;
@Data
@Component
public class UserUpdateDto {
	private Roles role;
	private String employeeName;
	private String employeeUserName;
	private String employeePassword;
	private UserStatus status;

}
