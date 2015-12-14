package com.thrust.event;

public final class EventReply {
	private final String _action;
	private final EventFields _event;
	private final Integer _id;
	private final Integer _target;
	private final String _type;
	
	public EventReply(String action, EventFields ef, Integer id, Integer target, String _type) {
		this._action = action;
		this._event = ef;
		this._id = id;
		this._target = target;
		this._type = _type;
	}
	
	public String getAction() {
		return _action;
	}
	
	public EventFields getEf() {
		return _event;
	}
	
	public Integer getId() {
		return _id;
	}
	
	public Integer getTarget() {
		return _target;
	}
	
	public String getType() {
		return _type;
	}
	
	@Override
	public String toString() {
		return "EventReply [action=" + _action +
				", ef=" + _event +
				", id=" + _id +
				", target=" + _target +
				", _type=" + _type
				+ "]";
	}
	
}
