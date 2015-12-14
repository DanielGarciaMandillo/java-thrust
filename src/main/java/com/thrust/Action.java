package com.thrust;

public final class Action {
	public static final Action CALL = new Action("call");
	public static final Action CREATE = new Action("create");
	private String _action;

	private Action(String action) {
		this._action = action;
	}

	public String getName() {
		return _action;
	}

	@Override
	public String toString() {
		return "Action [_action=" + _action + "]";
	}

}
