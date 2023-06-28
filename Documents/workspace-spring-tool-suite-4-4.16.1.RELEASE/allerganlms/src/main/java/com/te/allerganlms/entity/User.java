package com.te.allerganlms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employeeId")
	@SequenceGenerator(initialValue = 1, allocationSize = 100, name = "empID")
	private Integer employeeId;
	@NotBlank(message = "Employee Name cannot be empty")
	private String employeeName;
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeUserName")
//	@SequenceGenerator(allocationSize = 1, initialValue = 1, sequenceName = "empUserNameSeq", name = "empUserName")
	private String employeeUserName;
	@NotBlank(message = "password cannot be empty")
	private String employeePassword;
	private String role;
	private UserStatus status;

	@ManyToOne
	private GroupRoles groupRoles;
	@OneToOne(cascade = CascadeType.ALL)
	private UserJourney userJourney;

	

	

}
