package com.thrust;

import static com.thrust.Action.CALL;
import static com.thrust.Action.CREATE;
import static com.thrust.Method.EMPTY;
import static com.thrust.Method.IS_OFF_THE_RECORD;
import static com.thrust.Method.VISITED_LINK_ADD;
import static com.thrust.Method.VISITED_LINK_CLEAR;
import static com.thrust.Sender.sendCommand;
import static com.thrust.arguments.Argument.cookieStore;
import static com.thrust.arguments.Argument.offTheRecord;
import static com.thrust.arguments.Argument.path;
import static com.thrust.arguments.Argument.url;
import static com.thrust.remote.RemoteMethod.COOKIES_DELETE;
import static com.thrust.remote.RemoteMethod.COOKIES_LOAD;
import static com.thrust.remote.RemoteMethod.COOKIES_LOAD_FOR_KEY;
import static com.thrust.remote.RemoteMethod.COOKIES_UPDATE_ACCESS_TIME;
import static com.thrust.remote.RemoteMethods.setCallback;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static java.util.Optional.of;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.thrust.arguments.Argument;
import com.thrust.remote.Cookie;

public final class Session {
	
	private Integer id;
	private boolean offTheRecord;
	private boolean cookieStore;
	
	private Map<String, Set<Cookie>> cookies = new HashMap<>();
	
	private Session(Integer sessionId, boolean offTheRecord, String path, boolean cookieStore) {
		this.id = sessionId;
		this.offTheRecord = offTheRecord;
		this.cookieStore = cookieStore;
		
		setCallback(id, COOKIES_LOAD_FOR_KEY, args -> cookiesLoadForKey(args.getKey().get()));
		setCallback(id, COOKIES_LOAD, args -> cookiesAdd(args.getCookie().get()));
		setCallback(id, COOKIES_UPDATE_ACCESS_TIME, args -> cookiesUpdateAccessTime(args.getCookie().get()));
		setCallback(id, COOKIES_DELETE, args -> cookiesDelete(args.getCookie().get()));
	}

	public int visitedLinkAdded(String url) {
		return sendCommand(CALL, VISITED_LINK_ADD, empty(), of(id), asList(url(url)));
	}
	
	public int visitedLinkClear() {
		return sendCommand(CALL, VISITED_LINK_CLEAR, empty(), of(id), emptyList());
	}
	
	public CompletableFuture<Boolean> isOffTheRecord() {
		int mid = sendCommand(CALL, IS_OFF_THE_RECORD, empty(), of(id), emptyList());
		CompletableFuture<Boolean> ret = new CompletableFuture<>();
		MessageBox.addPromise(mid, ret);
		return ret;
	}
	
	private void cookiesDelete(Cookie cookie) {
		synchronized (cookies) {
			Set<Cookie> s = cookies.getOrDefault(cookie.getDomain(), new HashSet<>());
			s.remove(cookie);
			cookies.put(cookie.getDomain(), s);
		}
	}
	
	private void cookiesUpdateAccessTime(Cookie cookie) {
		synchronized (cookies) {
			Set<Cookie> s = cookies.getOrDefault(cookie.getDomain(), new HashSet<>());
			cookie.setLastAccess(new Date());
			s.add(cookie);
			cookies.put(cookie.getDomain(), s);
		}
	}
	
	private void cookiesAdd(Cookie cookie) {
		synchronized (cookies) {
			Set<Cookie> s = cookies.getOrDefault(cookie.getDomain(), new HashSet<>());
			s.add(cookie);
			cookies.put(cookie.getDomain(), s);
		}
	}
	
	private Set<Cookie> cookiesLoadForKey(String domain) {
		return cookies.get(domain);
	}
	
	public static CompletableFuture<Session> create(boolean offTheRecord, String path, boolean cookieStore) {
		List<Argument<?>> args = asList(offTheRecord(offTheRecord), path(path), cookieStore(cookieStore));
		int id = Sender.sendCommand(CREATE, EMPTY, of("session"), empty(), args);
		CompletableFuture<Integer> future = new CompletableFuture<>();
		MessageBox.addPromise(id, future);
		return future.thenApplyAsync(sessionId -> {
			MessageBox.removePromise(id);
			return new Session(sessionId, offTheRecord, path, cookieStore);
		});
	}
}
