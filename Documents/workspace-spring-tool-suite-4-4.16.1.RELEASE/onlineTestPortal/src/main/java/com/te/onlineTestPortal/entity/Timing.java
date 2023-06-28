package com.te.onlineTestPortal.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Timing {
	SESSIONI("8AM-10AM"), SESSIONII("10AM-12PM"), SESSIONIII("12PM-2PM"), SESSIONIV("2PM-4PM"), SESSIONV("4PM-6PM");

	String session;

	Timing(String session) {
		this.session = session;
	}
	
	public String	 getSession() {
		return session;
	}
}
