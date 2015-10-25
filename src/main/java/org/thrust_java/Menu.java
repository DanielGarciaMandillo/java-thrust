package org.thrust_java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import org.thrust_java.Arguments.Accelerator;
import org.thrust_java.Arguments.Arg_CommandId;
import org.thrust_java.Arguments.Arg_MenuId;
import org.thrust_java.Arguments.Argument;
import org.thrust_java.Arguments.Label;
import org.thrust_java.Arguments.Value;
import org.thrust_java.Sender.MenuId;
import org.thrust_java.ThrustShell.MessageId;

/**
 * Menu TERMINADO: QUEDAN LOS TODO
 *
 */
public class Menu {

	private Sender sender = new Sender();
	private MessageBox messageBox = new MessageBox();

	private MenuId id;
	private CommandId cmdId;
	private String label;
	private ConcurrentHashMap<CommandId, Item> items;
	private CopyOnWriteArraySet<Menu> subMenus;

	private int getCommandId;

	public Menu(MenuId id, CommandId cmdId, String label, ConcurrentHashMap<CommandId, Item> items,
			CopyOnWriteArraySet<Menu> subMenus) {
		this.id = id;
		this.cmdId = cmdId;
		this.label = label;
		this.items = items;
		this.subMenus = subMenus;
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

	public void addItem(Item i) throws IOException {
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

	public void add_check_item(CheckItem c) throws IOException {
		addItem(c);
	}

	public void add_radio_item(RadioItem r) throws IOException {
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

	public void add_separator() throws IOException {
		sender.sendCommand(new Actions().getCall(), new Methods().getAddSeparator(), null, id,
				new ArrayList<Argument>());
	}

	public void set_checked(CheckItem c, Boolean value) throws IOException {
		List<Argument> args = new ArrayList<>();
		Arg_CommandId arg1 = new Arguments().getArgCommandId();
		Value arg2 = new Arguments().getValue();

		arg1.setParam(c.getCmdId().getId().intValue());
		arg2.setParam(value);

		args.add(arg1);
		args.add(arg2);
		sender.sendCommand(new Actions().getCall(), new Methods().getSetChecked(), null, id, args);
	}

	public void set_enabled(Item i, Boolean value) throws IOException {
		List<Argument> args = new ArrayList<>();
		Arg_CommandId arg1 = new Arguments().getArgCommandId();
		Value arg2 = new Arguments().getValue();

		arg1.setParam(i.getCmdId().getId().intValue());
		arg2.setParam(value);

		args.add(arg1);
		args.add(arg2);
		sender.sendCommand(new Actions().getCall(), new Methods().getSetEnabled(), null, id, args);
	}

	public void set_visible(Item i, Boolean value) throws IOException {
		List<Argument> args = new ArrayList<>();
		Arg_CommandId arg1 = new Arguments().getArgCommandId();
		Value arg2 = new Arguments().getValue();

		arg1.setParam(i.getCmdId().getId().intValue());
		arg2.setParam(value);

		args.add(arg1);
		args.add(arg2);
		sender.sendCommand(new Actions().getCall(), new Methods().getSetEnabled(), null, id, args);
	}

	public void set_accelerator(Item i, String accl) throws IOException {
		List<Argument> args = new ArrayList<>();
		Arg_CommandId arg1 = new Arguments().getArgCommandId();
		Accelerator arg2 = new Arguments().getAccelerator();

		arg1.setParam(i.getCmdId().getId().intValue());
		arg2.setParam(accl);

		args.add(arg1);
		args.add(arg2);
		sender.sendCommand(new Actions().getCall(), new Methods().getSetAccelerator(), null, id, args);
	}

	public void addSubmenu(Menu m) throws IOException {

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

	public void clear() throws IOException {

		items.clear();
		subMenus.clear();

		sender.sendCommand(new Actions().getCall(), new Methods().getClear(), null, id, new ArrayList<Argument>());
	}

	public void popup(Window w) throws IOException {
		List<Argument> args = new ArrayList<>();
		Arg_MenuId arg1 = new Arguments().getArgMenuId();
		arg1.setParam(w.getId().getId());
		args.add(arg1);

		sender.sendCommand(new Actions().getCall(), new Methods().getPopup(), null, id, args);
	}

	public void set_application_menu() throws IOException {
		sender.sendCommand(new Actions().getCall(), new Methods().getSetApplicationMenu(), null, id,
				new ArrayList<Argument>());
	}

	// TODO Esto? No tiene metodo ni atributo ni nada, es un bloque de codigo
	// sin mas entre {}
	// {
	// Events.setCallback(id, EXECUTE, {
	// ef =>
	// items.get(CommandId(ef.commandId.get)).foreach(_.onExecute(ef.eventFlags.get))
	// })
	// }

	public Menu() {
		AtomicInteger nextCmdId = new AtomicInteger(0);
		getCommandId = nextCmdId.getAndIncrement();
	}

	public Menu(Integer id2, CommandId cmdId2, String label2, ConcurrentHashMap<CommandId, Item> items2,
			ArrayList<String> arrayList) {

	}

	public void create(String label) throws IOException, InterruptedException, ExecutionException {
		cmdId = new CommandId(new Integer(getCommandId));

		List<Argument> args = new ArrayList<>();
		Arg_CommandId arg1 = new Arguments().getArgCommandId();
		arg1.setParam(cmdId.getId());
		args.add(arg1);

		Label arg2 = new Arguments().getLabel();
		arg2.setParam(label);
		args.add(arg2);

		// TODO REPASAR ESTO
		// val p = Promise[Int]
		// val f = p.future
		// MessageBox.addPromise(id, p)
		// f.map { menuId =>
		// MessageBox.removePromise(id)
		// Menu(MenuId(menuId), cmdId, label, TrieMap.empty[CommandId, Item],
		// Seq())
		// }
		// }
		// }

		MessageId id = sender.sendCommand(new Actions().getCreate(), new Methods().getEmpty(), "menu", null, args);

		ExecutorService executor = Executors.newSingleThreadExecutor();
		final MessageId id2 = id;
		final String label2 = label;
		Future<Integer> f = executor.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				messageBox.removePromise(id2);
				MenuId m = sender.getMenuId();
				m.setId(id2.getId());
				new Menu(m.getId(), cmdId, label2, new ConcurrentHashMap<CommandId, Item>(), new ArrayList<String>());
				return m.getId();
			}
		});
		messageBox.addPromise(id, f);

	}

}
