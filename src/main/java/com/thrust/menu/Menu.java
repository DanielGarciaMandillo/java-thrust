package com.thrust.menu;

import static com.thrust.Action.CALL;
import static com.thrust.Action.CREATE;
import static com.thrust.Method.ADD_ITEM;
import static com.thrust.Method.ADD_SEPARATOR;
import static com.thrust.Method.ADD_SUBMENU;
import static com.thrust.Method.CLEAR;
import static com.thrust.Method.EMPTY;
import static com.thrust.Method.POPUP;
import static com.thrust.Method.SET_APPLICATION_MENU;
import static com.thrust.Method.SET_CHECKED;
import static com.thrust.Method.SET_ENABLED;
import static com.thrust.Method.SET_VISIBLE;
import static com.thrust.Sender.sendCommand;
import static com.thrust.arguments.Argument.accelerator;
import static com.thrust.arguments.Argument.argCommandId;
import static com.thrust.arguments.Argument.argGroupId;
import static com.thrust.arguments.Argument.argWindowId;
import static com.thrust.arguments.Argument.label;
import static com.thrust.arguments.Argument.value;
import static com.thrust.event.Event.EXECUTE;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static java.util.Optional.of;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.thrust.MessageBox;
import com.thrust.Window;
import com.thrust.arguments.Argument;
import com.thrust.event.Events;

public final class Menu {
	private final static AtomicInteger nextCmdId = new AtomicInteger(0);
	private final Integer id;
	private final Integer cmdId;
	private final String label;
	private final Map<Integer, Item> items = new ConcurrentHashMap<>();
	private final List<Menu> subMenus = new ArrayList<>();
	
	Menu(Integer id, Integer cmdId, String label) {
		this.id = id;
		this.cmdId = cmdId;
		this.label = label;
	}
	
	public int addItem(Item i) {
		items.put(i.getCmdId(), i);
		Events.setCallback(id, EXECUTE, i.getOnExecute());
		return sendCommand(CALL, ADD_ITEM, of("menu"), of(id),
				asList(argCommandId(i.getCmdId()), label(i.getLabel())));
	}
	
	public int addCheckItem(Item i) {
		return addItem(i);
	}
	
	public int addRadioItem(RadioItem i) {
		items.put(i.getCmdId(), i);
		Events.setCallback(id, EXECUTE, i.getOnExecute());
		return sendCommand(CALL, ADD_ITEM, of("menu"), of(id),
				asList(argCommandId(i.getCmdId()), label(i.getLabel()), argGroupId(i.getGroupId())));
	}
	
	public int addSeparator() {
		return sendCommand(CALL, ADD_SEPARATOR, empty(), of(id), emptyList());
	}
	
	public int setChecked(CheckItem i, boolean value) {
		return sendCommand(CALL, SET_CHECKED, empty(), of(id), asList(argCommandId(i.getCmdId()), value(value)));
	}
	
	public int setEnabled(Item i, boolean value) {
		return sendCommand(CALL, SET_ENABLED, empty(), of(id), asList(argCommandId(i.getCmdId()), value(value)));
	}
	
	public int setVisible(Item i, boolean value) {
		return sendCommand(CALL, SET_VISIBLE, empty(), of(id), asList(argCommandId(i.getCmdId()), value(value)));
	}
	
	public int setAccelerator(Item i, String accl) {
		return sendCommand(CALL, SET_VISIBLE, empty(), of(id), asList(argCommandId(i.getCmdId()), accelerator(accl)));
	}
	
	public int addSubMenu(Menu m) {
		synchronized (subMenus) {
			subMenus.add(m);
		}
		return sendCommand(CALL, ADD_SUBMENU, empty(), of(id), asList(Argument.argMenuId(m.id), label(m.label), argCommandId(m.cmdId)));
	}
	
	public int clear() {
		items.clear();
		synchronized (subMenus) {
			subMenus.clear();
		}
		return sendCommand(CALL, CLEAR, empty(), of(id), emptyList());
	}
	
	public int popup(Window w) {
		return sendCommand(CALL, POPUP, empty(), of(id), asList(argWindowId(w.getId())));
	}
	
	public int setApplicationMenu() {
		return sendCommand(CALL, SET_APPLICATION_MENU, empty(), of(id), emptyList());
	}
	
	public static int getCommandId() {
		return nextCmdId.getAndIncrement();
	}
	
	public static CompletableFuture<Menu> create(String label) {
		int cmdId = getCommandId();
		List<Argument<?>> args = asList(argCommandId(cmdId), label(label));
		int id = sendCommand(CREATE, EMPTY, of("menu"), empty(), args);
		CompletableFuture<Integer> future = new CompletableFuture<>();
		MessageBox.addPromise(id, future);
		return future.thenApplyAsync(menuId -> {
			MessageBox.removePromise(id);
			return new Menu(menuId, cmdId, label);
		});
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", cmdId=" + cmdId + ", label=" + label + ", items=" + items + ", subMenus="
				+ subMenus + "]";
	}
	
}
