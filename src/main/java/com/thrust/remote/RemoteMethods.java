package com.thrust.remote;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import com.thrust.utils.Args;
import com.thrust.utils.Tuple;

public class RemoteMethods {
	private static Map<Tuple<Integer, RemoteMethod>, Consumer<Args>> callbackMap = new ConcurrentHashMap<>();

	private RemoteMethods() {
	}

	public static CompletableFuture<Void> callback(Integer id, RemoteMethod e, Args args) {
		return CompletableFuture.runAsync(() -> callbackMap.get(Tuple.of(id, e)).accept(args));
	}

	public static Consumer<Args> setCallback(Integer id, RemoteMethod e, Consumer<Args> f) {
		return callbackMap.put(Tuple.of(id, e), f);
	}
}
