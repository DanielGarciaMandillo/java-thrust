package com.thrust.event;

import java.util.Optional;

public class EventFields {
	private final Optional<Integer> commandId;
	private final Optional<Integer> eventFlags;

	public EventFields(Optional<Integer> commandId, Optional<Integer> eventFlags) {
		this.commandId = commandId;
		this.eventFlags = eventFlags;
	}

	public Optional<Integer> getCommandId() {
		return commandId;
	}

	public Optional<Integer> getEventFlags() {
		return eventFlags;
	}

	@Override
	public String toString() {
		return "EventFields [commandId=" + commandId + ", eventFlags=" + eventFlags + "]";
	}

}
