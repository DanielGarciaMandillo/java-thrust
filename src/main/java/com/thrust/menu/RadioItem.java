package com.thrust.menu;

import java.util.function.Consumer;

import com.thrust.event.EventFields;

public class RadioItem extends Item {

	private final Integer groupId;

	public RadioItem(int cmdId, String label, Integer groupId, Consumer<EventFields> onExecute) {
		super(cmdId, label, onExecute);
		this.groupId = groupId;
	}

	public static RadioItem create(String label, Integer groupId, Consumer<EventFields> onExecute) {
		return new RadioItem(Menu.getCommandId(), label, groupId, onExecute);
	}

	public Integer getGroupId() {
		return groupId;
	}

	@Override
	public String toString() {
		return "RadioItem [groupId=" + groupId + ", cmdId=" + cmdId + ", label=" + label + ", onExecute=" + onExecute
				+ "]";
	}

}
