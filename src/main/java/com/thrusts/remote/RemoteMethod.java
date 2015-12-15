package com.thrusts.remote;

import java.util.Arrays;

public enum RemoteMethod {
	COOKIES_LOAD("cookies_load"), 
	COOKIES_LOAD_FOR_KEY("cookies_load_for_key"), 
	COOKIES_FLUSH("cookies_flush"), 
	COOKIES_ADD("cookies_add"), 
	COOKIES_UPDATE_ACCESS_TIME("cookies_update_access_time"), 
	COOKIES_DELETE("cookies_delete"), 
	COOKIES_FORCE_KEEP_SESSION_STATE("cookies_force_keep_session_state");
							
	private final String name;
	
	RemoteMethod(String name) {
		this.name = name;
	}
	
	public static RemoteMethod fromString(String name) {
		return Arrays.stream(RemoteMethod.values())
				.filter(e -> e.name.equals(name))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException(String.format("Unsupported type %s.", name)));
	}
}
