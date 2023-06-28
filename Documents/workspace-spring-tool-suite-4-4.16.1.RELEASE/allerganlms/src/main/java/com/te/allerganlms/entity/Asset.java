package com.te.allerganlms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer courseId;
	private String courseName;
	private Status status;
	private String type;
	@Lob
	private byte[] courseData;

	@ManyToOne
	private GroupRoles groupRoles;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Quiz> quiz;
	@ManyToOne(cascade = CascadeType.ALL)
	private UserJourney userJourney;
	
}
