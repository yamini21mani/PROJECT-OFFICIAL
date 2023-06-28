package com.te.allerganlms.dto;

import javax.persistence.Lob;

import org.springframework.stereotype.Component;

import com.te.allerganlms.entity.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class AssetDto {
	private Integer courseId;
	private String courseName;
	private Status status;
	private String type;
	@Lob
	private byte[] courseData;

}
