package org.thrust_java;

import org.utils.Json;

/**
 * Actions
 *
 */
public class Actions {

	public static Json actionToJson(Action a) {
		return a.toJson();
	}

	abstract class Action {
		public abstract Json toJson();
	}
	
	public Create getCreate(){
		return new Create();
	}
	
	public Call getCall(){
		return new Call();
	}

	class Create extends Action {
		@Override
		public Json toJson() {
			return new Json("_action", "create");
		}
	}

	class Call extends Action {
		@Override
		public Json toJson() {
			return new Json("_action", "call");
		}
	}

}
