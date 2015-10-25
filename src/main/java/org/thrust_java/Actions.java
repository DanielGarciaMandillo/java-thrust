package org.thrust_java;

import org.utils.Json;

/**
 * Actions TERMINADO
 *
 */
public class Actions {

	public static Json actionToJson(Action a) {
		return a.toJson();
	}

	abstract class Action {
		public abstract Json toJson();
	}
	
	public CREATE getCreate(){
		return new CREATE();
	}
	
	public CALL getCall(){
		return new CALL();
	}

	class CREATE extends Action {
		@Override
		public Json toJson() {
			return new Json("_action", "create");
		}
	}

	class CALL extends Action {
		@Override
		public Json toJson() {
			return new Json("_action", "call");
		}
	}

}
