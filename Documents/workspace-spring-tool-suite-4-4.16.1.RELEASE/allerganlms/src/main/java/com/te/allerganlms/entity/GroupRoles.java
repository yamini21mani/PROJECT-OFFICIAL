package com.te.allerganlms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class GroupRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer groupId;
	private String groupName;
	private String groupRole;
	private GroupStatus groupStatus;

	@OneToMany(cascade = CascadeType.ALL)
	private List<User> user;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Asset> assets;
	@OneToOne(cascade = CascadeType.ALL)
	private UserJourney userJourney;

}
