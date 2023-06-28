package com.te.allerganlms.dto;

import org.springframework.stereotype.Component;

import com.te.allerganlms.entity.UserStatus;

import lombok.Data;
@Data
@Component
public class UserCreationDto {
	private String employeeName;
	private String employeePassword;
	private UserStatus status;
	private String role;

}
