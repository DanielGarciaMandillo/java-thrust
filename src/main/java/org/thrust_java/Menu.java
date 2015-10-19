package org.thrust_java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import org.thrust_java.Arguments.Accelerator;
import org.thrust_java.Arguments.Arg_CommandId;
import org.thrust_java.Arguments.Arg_MenuId;
import org.thrust_java.Arguments.Argument;
import org.thrust_java.Arguments.Label;
import org.thrust_java.Arguments.Value;
import org.thrust_java.Sender.MenuId;

/**
 * Menu
 *
 */
public class Menu {

	private Sender sender = new Sender();
	private MenuId id;
	private CommandId cmdId;
	private String label;
	private ConcurrentHashMap<CommandId, Item> items;
	private CopyOnWriteArraySet<Menu> subMenus;

	public Menu(MenuId id, CommandId cmdId, String label, ConcurrentHashMap<CommandId, Item> items,
			CopyOnWriteArraySet<Menu> subMenus) {
		this.id = id;
		this.cmdId = cmdId;
		this.label = label;
		this.items = items;
		this.subMenus = subMenus;
	}

	public Menu() {
	}

	public MenuId getId() {
		return id;
	}

	public void setId(MenuId id) {
		this.id = id;
	}

	public CommandId getCmdId() {
		return cmdId;
	}

	public void setCmdId(CommandId cmdId) {
		this.cmdId = cmdId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ConcurrentHashMap<CommandId, Item> getItems() {
		return items;
	}

	public void setItems(ConcurrentHashMap<CommandId, Item> items) {
		this.items = items;
	}

	public CopyOnWriteArraySet<Menu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(CopyOnWriteArraySet<Menu> subMenus) {
		this.subMenus = subMenus;
	}

	class CommandId {
		Integer id;

		public CommandId(Integer value) {
			id = new Integer(value);
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
	}

	class GroupId {
		Integer id;

		public GroupId(Integer value) {
			id = new Integer(value);
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
	}

	class Item {
		CommandId cmdId = null;
		String label = null;
		Callable<?> onExecute = null;

		public CommandId getCmdId() {
			return cmdId;
		}

		public String getLabel() {
			return label;
		}

		public Callable<?> getOnExecute() {
			return onExecute;
		}
	}

	class MenuItem extends Item {

		public MenuItem(CommandId cmdId, String lbl, Callable<?> function) {
			this.cmdId = cmdId;
			this.label = lbl;
			this.onExecute = function;
		}

		public void apply(String lbl, Callable<?> function) {
			new MenuItem(getCmdId(), lbl, function);
		}
	}

	class CheckItem extends Item {

		public CheckItem(CommandId cmdId, String lbl, Callable<?> function) {
			this.cmdId = cmdId;
			this.label = lbl;
			this.onExecute = function;
		}

		public void apply(String lbl, Callable<?> function) {
			new MenuItem(getCmdId(), lbl, function);
		}
	}

	class RadioItem extends Item {

		public RadioItem(CommandId cmdId, String lbl, Callable<?> function) {
			this.cmdId = cmdId;
			this.label = lbl;
			this.onExecute = function;
		}

		public void apply(String lbl, Callable<?> function) {
			new MenuItem(getCmdId(), lbl, function);
		}
	}

	public void addItem(Item i) {
		// TODO Esto en Scala: con el ifAbsent no seria necesario??
		// items.synchronized {
		// items += (i.cmdId -> i)
		// }
		items.putIfAbsent(i.getCmdId(), i);

		List<Argument> args = new ArrayList<>();
		Arg_CommandId arg1 = new Arguments().getArgCommandId();
		Label arg2 = new Arguments().getLabel();

		arg1.setParam(i.getCmdId().getId().intValue());
		arg2.setParam(i.getLabel());

		args.add(arg1);
		args.add(arg2);

		sender.sendCommand(new Actions().getCall(), new Methods().getAddItem(), "menu", id, args);
	}

	public void add_check_item(CheckItem c) {
		addItem(c);
	}

	public void add_radio_item(RadioItem r) {
		items.putIfAbsent(r.getCmdId(), r);

		List<Argument> args = new ArrayList<>();
		Arg_CommandId arg1 = new Arguments().getArgCommandId();
		Label arg2 = new Arguments().getLabel();

		arg1.setParam(r.getCmdId().getId().intValue());
		arg2.setParam(r.getLabel());

		args.add(arg1);
		args.add(arg2);

		sender.sendCommand(new Actions().getCall(), new Methods().getAddItem(), "menu", id, args);
	}

	public void add_separator() {
		sender.sendCommand(new Actions().getCall(), new Methods().getAddSeparator(), null, id,
				new ArrayList<Argument>());
	}

	public void set_checked(CheckItem c, Boolean value) {
		List<Argument> args = new ArrayList<>();
		Arg_CommandId arg1 = new Arguments().getArgCommandId();
		Value arg2 = new Arguments().getValue();

		arg1.setParam(c.getCmdId().getId().intValue());
		arg2.setParam(value);

		args.add(arg1);
		args.add(arg2);
		sender.sendCommand(new Actions().getCall(), new Methods().getSetChecked(), null, id, args);
	}

	public void set_enabled(Item i, Boolean value) {
		List<Argument> args = new ArrayList<>();
		Arg_CommandId arg1 = new Arguments().getArgCommandId();
		Value arg2 = new Arguments().getValue();

		arg1.setParam(i.getCmdId().getId().intValue());
		arg2.setParam(value);

		args.add(arg1);
		args.add(arg2);
		sender.sendCommand(new Actions().getCall(), new Methods().getSetEnabled(), null, id, args);
	}

	public void set_visible(Item i, Boolean value) {
		List<Argument> args = new ArrayList<>();
		Arg_CommandId arg1 = new Arguments().getArgCommandId();
		Value arg2 = new Arguments().getValue();

		arg1.setParam(i.getCmdId().getId().intValue());
		arg2.setParam(value);

		args.add(arg1);
		args.add(arg2);
		sender.sendCommand(new Actions().getCall(), new Methods().getSetEnabled(), null, id, args);
	}

	public void set_accelerator(Item i, String accl) {
		List<Argument> args = new ArrayList<>();
		Arg_CommandId arg1 = new Arguments().getArgCommandId();
		Accelerator arg2 = new Arguments().getAccelerator();

		arg1.setParam(i.getCmdId().getId().intValue());
		arg2.setParam(accl);

		args.add(arg1);
		args.add(arg2);
		sender.sendCommand(new Actions().getCall(), new Methods().getSetAccelerator(), null, id, args);
	}

	public void addSubmenu(Menu m) {

		subMenus.add(m);

		List<Argument> args = new ArrayList<>();

		Arg_MenuId arg1 = new Arguments().getArgMenuId();
		Label arg2 = new Arguments().getLabel();
		Arg_CommandId arg3 = new Arguments().getArgCommandId();

		arg1.setParam(m.getId().getId());
		arg2.setParam(m.getLabel());
		arg3.setParam(m.getCmdId().getId().intValue());

		args.add(arg1);
		args.add(arg2);
		args.add(arg3);

		sender.sendCommand(new Actions().getCall(), new Methods().getAddSubmenu(), null, id, args);
	}

	public void clear() {
		// TODO ESTO QUE ES? FILTER
		// items.synchronized(items.filter(_ => false))
		// subMenus.synchronized(subMenus.filter(_ => false))
		sender.sendCommand(new Actions().getCall(), new Methods().getClear(), null, id, new ArrayList<Argument>());
	}
	
	//TODO CREAR WINDOW
	public void popup(Window w) {
		List<Argument> args = new ArrayList<>();
		Arg_MenuId arg1 = new Arguments().getArgMenuId();
		arg1.setParam(w.getId().getId());
		args.add(arg1);

		sender.sendCommand(new Actions().getCall(), new Methods().getPopup(), null, id, args);
	}

}
