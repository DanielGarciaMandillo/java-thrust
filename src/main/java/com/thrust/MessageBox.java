package com.thrust;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public final class MessageBox {
	
	private static final Map<Integer, CompletableFuture<?>> promiseMap = new ConcurrentHashMap<>();
	
	public static <T> void addPromise(Integer id, CompletableFuture<T> p) {
		promiseMap.put(id, p);
	}
	
	public static <T> CompletableFuture<T> removePromise(Integer id) {
		return (CompletableFuture<T>) promiseMap.remove(id);
	}
	
	public static <T> CompletableFuture<T> getPromise(Integer id) {
		return (CompletableFuture<T>) promiseMap.get(id);
	}
}
