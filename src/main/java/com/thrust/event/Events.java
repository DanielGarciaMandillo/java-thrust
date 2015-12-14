package com.thrust.event;

import static com.thrust.event.Event.BLURRED;
import static com.thrust.event.Event.CLOSED;
import static com.thrust.event.Event.FOCUSED;
import static com.thrust.event.Event.RESPONSIVE;
import static com.thrust.event.Event.UNRESPONSIVE;
import static com.thrust.event.Event.WORKER_CRASHED;
import static java.util.Arrays.asList;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import com.thrust.utils.Tuple;

public final class Events {
	private static Map<Tuple<Integer, Event>, Consumer<EventFields>> callbackMap = new ConcurrentHashMap<>();

	private Events() {
	}

	public static CompletableFuture<Void> callback(Integer id, Event e, EventFields ef) {
		return CompletableFuture.runAsync(() -> callbackMap.get(Tuple.of(id, e)).accept(ef));
	}

	public static Consumer<EventFields> setCallback(Integer id, Event e, Consumer<EventFields> f) {
		return callbackMap.put(Tuple.of(id, e), f);
	}

	public static void removeForWindow(Integer id) {
		asList(BLURRED, FOCUSED, CLOSED, UNRESPONSIVE, RESPONSIVE, WORKER_CRASHED)
				.forEach(e -> callbackMap.remove(Tuple.of(id, e)));
	}

}
