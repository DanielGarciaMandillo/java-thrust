package com.thrust.menu;

import java.util.function.Consumer;

import com.thrust.event.EventFields;

public class CheckItem extends Item {

	public CheckItem(int cmdId, String label, Consumer<EventFields> onExecute) {
		super(cmdId, label, onExecute);
	}

	public static CheckItem create(String label, Consumer<EventFields> onExecute) {
		return new CheckItem(Menu.getCommandId(), label, onExecute);
	}

	@Override
	public String toString() {
		return "CheckItem [cmdId=" + cmdId + ", label=" + label + ", onExecute=" + onExecute + "]";
	}

}
