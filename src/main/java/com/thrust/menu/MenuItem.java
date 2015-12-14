package com.thrust.menu;

import java.util.function.Consumer;

import com.thrust.event.EventFields;

public class MenuItem extends Item {
	
	public MenuItem(int cmdId, String label, Consumer<EventFields> onExecute) {
		super(cmdId, label, onExecute);
	}
	
	public static MenuItem create(String label, Consumer<EventFields> onExecute) {
		return new MenuItem(Menu.getCommandId(), label, onExecute);
	}

	@Override
	public String toString() {
		return "MenuItem [cmdId=" + cmdId + ", label=" + label + ", onExecute=" + onExecute + "]";
	}
	
}
