package com.thrust.utils;

import com.thrust.remote.RemoteArgument;

public final class Key implements RemoteArgument {
	private final String key;
	
	public Key(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
	@Override
	public String toString() {
		return "Key [key=" + key + "]";
	}
}
