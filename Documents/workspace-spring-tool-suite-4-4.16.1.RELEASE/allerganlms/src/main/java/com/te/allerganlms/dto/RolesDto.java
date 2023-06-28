package com.te.allerganlms.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class RolesDto {
	private Integer roleId;
	private String roleName;
}
