package com.thrust.menu;

import java.util.function.Consumer;

import com.thrust.event.EventFields;

public class Item {
	protected final int cmdId;
	protected final String label;
	protected final Consumer<EventFields> onExecute;
	
	public Item(int cmdId, String label, Consumer<EventFields> onExecute) {
		this.cmdId = cmdId;
		this.label = label;
		this.onExecute = onExecute;
	}
	
	public int getCmdId() {
		return cmdId;
	}
	
	public String getLabel() {
		return label;
	}
	
	public Consumer<EventFields> getOnExecute() {
		return onExecute;
	}
	
	@Override
	public String toString() {
		return "Item [cmdId=" + cmdId + ", label=" + label + ", onExecute=" + onExecute + "]";
	}
	
}
