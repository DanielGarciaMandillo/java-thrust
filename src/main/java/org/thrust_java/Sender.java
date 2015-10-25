package org.thrust_java;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.thrust_java.Actions.Action;
import org.thrust_java.Arguments.Argument;
import org.thrust_java.Methods.Method;
import org.thrust_java.ThrustShell.MessageId;

/**
 * Sender : TERMINADO QUEDA EL TODO
 *
 */
public class Sender {

	class TargetId {
		Integer id = null;

		public Integer getId() {
			return id;
		}

		public void setId(Integer i) {
			id = i;
		}
	}

	class WinId extends TargetId {

	}

	class MenuId extends TargetId {
		
	}

	class SessionId extends TargetId {
	}
	
	public MenuId getMenuId(){
		return new MenuId();
	}

	private String boundary = "\n--(Foo)++__THRUST_SHELL_BOUNDARY__++(Bar)--\n";
	private AtomicInteger nextId = new AtomicInteger(1);

	public MessageId sendCommand(Action action, Method method, String _type, TargetId target, List<Argument> args)
			throws IOException {
		int id = nextId.getAndIncrement();
		MessageId msgId = new ThrustShell().getMessageId();
		msgId.setId(id);

		// TODO COMO funciona ESTO¿?¿??¿
		// val jsonCommand = ("_args" -> args.foldRight(jEmptyObject)(_ ->: _))
		// ->: ("_target" :=? target.map(_.id)) ->?: ("_type" :=? _type) ->?:
		// method ->: action ->: ("_id" -> jNumber(id)) ->: jEmptyObject
		String jsonCommand = "";
		ThrustShell ts = new ThrustShell();
		// ts.out.write(jsonCommand.toString()+boundary).getBytes();
		ts.out.write(jsonCommand.getBytes());
		ts.out.flush();
		return msgId;

	}

}
