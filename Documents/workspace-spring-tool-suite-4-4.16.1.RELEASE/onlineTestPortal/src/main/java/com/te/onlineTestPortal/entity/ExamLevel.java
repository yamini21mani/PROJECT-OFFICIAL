package com.te.onlineTestPortal.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ExamLevel {
	ENTRY("ENTRY"), INTERMEDIATE("INTERMEDIATE"), ADVANCED("ADVANCED");

	String level;

	ExamLevel(String level) {
		this.level = level;
	}
}
