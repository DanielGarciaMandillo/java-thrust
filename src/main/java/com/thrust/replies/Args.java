package com.thrust.replies;

import static java.util.Optional.ofNullable;

import java.util.Optional;

public final class Args {
	private final Cookie cookie;
	private final String key;

	public Args(Cookie cookie, String key) {
		this.cookie = cookie;
		this.key = key;
	}

	public Optional<Cookie> getCookie() {
		return ofNullable(cookie);
	}

	public Optional<String> getKey() {
		return ofNullable(key);
	}

	@Override
	public String toString() {
		return "Args [cookie=" + cookie + ", key=" + key + "]";
	}

}
