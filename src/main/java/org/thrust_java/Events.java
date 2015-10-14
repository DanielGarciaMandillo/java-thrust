package org.thrust_java;

import java.util.concurrent.ConcurrentHashMap;

import org.thrust_java.Replies.EventFields;
import org.utils.IntegerEvent;

/**
 * Actions
 *
 */
public class Events {
	
	private ConcurrentHashMap<IntegerEvent,EventFields> callbackMap;
	
	public Events(){
		callbackMap = new ConcurrentHashMap<>();
	}

	public void callback(Integer id, Event e, EventFields ef){
		callbackMap.putIfAbsent(new IntegerEvent(id, e), ef);
	}
	
	public void setCallback(Integer id, Event e, EventFields ef){
		callbackMap.replace(new IntegerEvent(id, e), ef);
	}
	
//	TODO ¿COMO HACER ESTO? AL SER NUEVO OBJETO NUNCA BORRA LA CLAVE
//	public void removeForWindow(Integer id){
//		callbackMap.remove(new IntegerEvent(id, Blurred);
//	}

	public ConcurrentHashMap<IntegerEvent,EventFields> getCallbackMap() {
		return callbackMap;
	}

	public void setCallbackMap(ConcurrentHashMap<IntegerEvent,EventFields> callbackMap) {
		this.callbackMap = callbackMap;
	}
	
	public Event fromString(String s) {
		switch (s) {
		case "blur":
			return getBlur();
		case "focus":
			return getFocus();
		case "closed":
			return getClosed();
		case "unresponsive":
			return getUnresponsive();
		case "responsive":
			return getResponsive();
		case "worker_crashed":
			return getWorkerCrashed();
		case "execute":
			return getExecute();
		default:
			return null;
		}

	}

	public Blurred getBlur() {
		return new Blurred();
	}

	public Focused getFocus() {
		return new Focused();
	}

	public Closed getClosed() {
		return new Closed();
	}

	public Unresponsive getUnresponsive() {
		return new Unresponsive();
	}

	public Responsive getResponsive() {
		return new Responsive();
	}

	public WorkerCrashed getWorkerCrashed() {
		return new WorkerCrashed();
	}

	public Execute getExecute() {
		return new Execute();
	}

	public abstract class Event {

	}

	public class Blurred extends Event {
		public Blurred() {
		}
	}

	public class Focused extends Event {
		public Focused() {
		}
	}

	public class Closed extends Event {
		public Closed() {
		}
	}

	public class Unresponsive extends Event {
		public Unresponsive() {
		}
	}

	public class Responsive extends Event {
		public Responsive() {
		}
	}

	public class WorkerCrashed extends Event {
		public WorkerCrashed() {
		}
	}

	public class Execute extends Event {
		public Execute() {
		}
	}

}
