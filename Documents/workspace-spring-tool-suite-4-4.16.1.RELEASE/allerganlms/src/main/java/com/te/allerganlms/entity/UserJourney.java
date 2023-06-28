package com.te.allerganlms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class UserJourney {
	@Id
	private String employeeUserName;
	@OneToMany
	private List<Asset> assets;
	@OneToOne
	private User user;
	@OneToOne
	private GroupRoles groupRoles;

}
