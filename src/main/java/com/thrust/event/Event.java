package com.thrust.event;

import java.util.Arrays;

public enum Event {
	BLURRED("blur"), 
	FOCUSED("focus"), 
	CLOSED("closed"), 
	UNRESPONSIVE("unresponsive"), 
	RESPONSIVE("responsive"), 
	WORKER_CRASHED("worker_crashed"), 
	EXECUTE("execute");
			
	private String event;
	
	Event(String event) {
		this.event = event;
	}
	
	public static Event fromString(String event) {
		return Arrays.stream(Event.values())
				.filter(e -> e.event.equals(event))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", event)));
	}
}
