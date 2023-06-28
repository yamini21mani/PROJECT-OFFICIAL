package com.te.allerganlms.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class GroupRolesDto {
	private String groupName;
	private String groupRole;
	private String groupStatus;
}
