package com.te.onlineTestPortal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Instructions {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="id")
	@SequenceGenerator(name = "id",initialValue = 1)
	private Integer instructionId;
	private String instruction;
}
