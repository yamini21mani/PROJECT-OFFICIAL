package com.te.onlineTestPortal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	private String userId;
	private String password;
	private String userName;
	private String userOrganization;
	private Long contactNo;
	private String email;
}
