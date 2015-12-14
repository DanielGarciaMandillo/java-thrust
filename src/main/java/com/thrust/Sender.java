package com.thrust;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.gson.Gson;
import com.thrust.arguments.Argument;

public class Sender {
	static final String boundary = "\n--(Foo)++__THRUST_SHELL_BOUNDARY__++(Bar)--\n";
	static final AtomicInteger nextId = new AtomicInteger(1);
	
	private Sender() {
	}
	
	static class Command {
		private int _id;
		private String _action;
		private String _method;
		private String _type;
		private Integer _target;
		private Map _args = new HashMap();
		
		Command(int id, Action action, Method method, Optional<String> type, Optional<Integer> target,
				List<Argument<?>> args) {
			this._id = id;
			this._action = action.getName();
			this._method = method.getName();
			this._type = type.orElse(null);
			this._target = target.orElse(null);
			args.forEach(p -> _args.put(p.getName(), p.getValue()));
		}
	}
	
	public static int sendCommand(Action action, Method method, Optional<String> type, Optional<Integer> target,
			List<Argument<?>> args) {
		try {
			int id = nextId.getAndIncrement();
			Command cmd = new Command(id, action, method, type, target, args);
			String jsonCommand = new Gson().toJson(cmd);
			System.out.println(String.format("Sending: %s", jsonCommand));
			ThrustShell.getShell().out.write((jsonCommand + boundary).getBytes());
			ThrustShell.getShell().out.flush();
			return id;
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}
