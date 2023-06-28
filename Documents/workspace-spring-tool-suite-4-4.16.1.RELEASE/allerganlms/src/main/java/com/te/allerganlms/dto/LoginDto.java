package com.te.allerganlms.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class LoginDto {
	private String employeeUserName;
	private String employeePassword;
}
