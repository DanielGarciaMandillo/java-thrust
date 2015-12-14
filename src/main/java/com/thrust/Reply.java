package com.thrust;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import com.thrust.remote.RemoteMethod;
import com.thrust.utils.Args;
import com.thrust.utils.Result;

public final class Reply {
	private final String _action;
	private final RemoteMethod _method;
	private final Args _args;
	private final String _error;
	private final Integer _id;
	private final Result _result;
	
	public Reply(String action, RemoteMethod method, Args args, String error, Integer id, Result result) {
		this._action = action;
		this._method = method;
		this._args = args;
		this._error = error;
		this._id = id;
		this._result = result;
	}
	
	public String getAction() {
		return _action;
	}
	
	public Optional<RemoteMethod> getMethod() {
		return ofNullable(_method);
	}
	
	public Optional<Args> getArgs() {
		return ofNullable(_args);
	}
	
	public String getError() {
		return _error;
	}
	
	public Integer getId() {
		return _id;
	}
	
	public Result getResult() {
		return _result;
	}
	
	@Override
	public String toString() {
		return "Reply [action=" + _action + ", method=" + _method + ", args=" + _args + ", error=" + _error + ", id="
				+ _id
				+ ", result=" + _result + "]";
	}
	
}
