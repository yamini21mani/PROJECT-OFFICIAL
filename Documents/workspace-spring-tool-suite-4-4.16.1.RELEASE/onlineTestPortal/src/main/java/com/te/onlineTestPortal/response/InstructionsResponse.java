package com.te.onlineTestPortal.response;

import java.util.List;

import com.te.onlineTestPortal.entity.Instructions;

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
@Setter
@Getter
public class InstructionsResponse {
	private List<Instructions> rules;
	private String message;

}
