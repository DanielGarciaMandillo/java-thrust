package com.thrust;

import static com.thrust.Action.CALL;
import static com.thrust.Action.CREATE;
import static com.thrust.Method.CLOSE_DEV_TOOLS;
import static com.thrust.Method.EMPTY;
import static com.thrust.Method.FOCUS;
import static com.thrust.Method.IS_CLOSED;
import static com.thrust.Method.IS_DEV_TOOLS_OPENED;
import static com.thrust.Method.IS_FULLSCREEN;
import static com.thrust.Method.IS_KIOSKED;
import static com.thrust.Method.IS_MAXIMIZED;
import static com.thrust.Method.IS_MINIMIZED;
import static com.thrust.Method.MAXIMIZE;
import static com.thrust.Method.MINIMIZE;
import static com.thrust.Method.MOVE;
import static com.thrust.Method.OPEN_DEV_TOOLS;
import static com.thrust.Method.POSITION;
import static com.thrust.Method.RESIZE;
import static com.thrust.Method.RESTORE;
import static com.thrust.Method.SET_FULLSCREEN;
import static com.thrust.Method.SET_KIOSK;
import static com.thrust.Method.SET_TITLE;
import static com.thrust.Method.SHOW;
import static com.thrust.Method.SIZE;
import static com.thrust.Sender.sendCommand;
import static com.thrust.arguments.Argument.iconPath;
import static com.thrust.arguments.Argument.position;
import static com.thrust.arguments.Argument.rootUrl;
import static com.thrust.arguments.Argument.size;
import static com.thrust.arguments.Argument.title;
import static com.thrust.event.Event.BLURRED;
import static com.thrust.event.Event.FOCUSED;
import static com.thrust.event.Event.RESPONSIVE;
import static com.thrust.event.Event.UNRESPONSIVE;
import static com.thrust.event.Event.WORKER_CRASHED;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import com.thrust.arguments.Argument;
import com.thrust.event.Event;
import com.thrust.event.EventFields;
import com.thrust.event.Events;
import com.thrust.utils.Position;
import com.thrust.utils.Size;

public class Window {
	private static final Size DEFAULT_SIZE = new Size(1280, 720);
	private final Integer id;
	private final String rootUrl;
	private final Size size;
	private final String title;
	private final String iconPath;
	private final Optional<Integer> sessionId;
	private Runnable closedHandler = () -> {
	};

	Window(Integer id, String rootUrl, Size size, String title, String iconPath, Optional<Integer> sessionId) {
		this.id = id;
		this.rootUrl = rootUrl;
		this.size = size;
		this.title = title;
		this.iconPath = iconPath;
		this.sessionId = sessionId;

		Events.setCallback(id, Event.CLOSED, e -> {
			Events.removeForWindow(id);
			closedHandler.run();
		});
	}

	public void show() {
		sendCommand(CALL, SHOW, empty(), of(id), emptyList());
	}

	public void focus(boolean blur) {
		sendCommand(CALL, FOCUS, empty(), of(id), asList(Argument.focus(blur)));
	}

	public void maximize() {
		sendCommand(CALL, MAXIMIZE, empty(), of(id), emptyList());
	}

	public void minimize() {
		sendCommand(CALL, MINIMIZE, empty(), of(id), emptyList());
	}

	public void restore() {
		sendCommand(CALL, RESTORE, empty(), of(id), emptyList());
	}

	public void setTitle(String title) {
		sendCommand(CALL, SET_TITLE, empty(), of(id), asList(title(title)));
	}

	public void setFullscreen() {
		sendCommand(CALL, SET_FULLSCREEN, empty(), of(id), emptyList());
	}

	public void setKiosk() {
		sendCommand(CALL, SET_KIOSK, empty(), of(id), emptyList());
	}

	public void openDevtools() {
		sendCommand(CALL, OPEN_DEV_TOOLS, empty(), of(id), emptyList());
	}

	public void closeDevtools() {
		sendCommand(CALL, CLOSE_DEV_TOOLS, empty(), of(id), emptyList());
	}

	public void move(Position position) {
		sendCommand(CALL, MOVE, empty(), of(id), asList(position(position)));
	}

	public void resize(Size s) {
		sendCommand(CALL, RESIZE, empty(), of(id), asList(size(s)));
	}

	private <T> CompletableFuture<T> callAndGet(Method m) {
		int cmdId = sendCommand(CALL, m, empty(), of(id), emptyList());
		CompletableFuture<T> future = new CompletableFuture<>();
		MessageBox.addPromise(cmdId, future);
		return future;
	}

	public CompletableFuture<Boolean> isClosed() {
		return callAndGet(IS_CLOSED);
	}

	public CompletableFuture<Size> getSize() {
		return callAndGet(SIZE);
	}

	public CompletableFuture<Size> getPosition() {
		return callAndGet(POSITION);
	}

	public CompletableFuture<Boolean> isMaximized() {
		return callAndGet(IS_MAXIMIZED);
	}


	public CompletableFuture<Boolean> isMinimized() {
		return callAndGet(IS_MINIMIZED);
	}

	public CompletableFuture<Boolean> isFullscreen() {
		return callAndGet(IS_FULLSCREEN);
	}

	public CompletableFuture<Boolean> isKiosked() {
		return callAndGet(IS_KIOSKED);
	}

	public CompletableFuture<Boolean> isDevtoolsOpened() {
		return callAndGet(IS_DEV_TOOLS_OPENED);
	}

	public void onBlur(Consumer<EventFields> f) {
		Events.setCallback(id, BLURRED, f);
	}

	public void onFocus(Consumer<EventFields> f) {
		Events.setCallback(id, FOCUSED, f);
	}

	public void onClosed(Consumer<EventFields> f) {
		onClosed(f, true);
	}

	public void onClosed(Consumer<EventFields> f, boolean exiting) {
		synchronized (closedHandler) {
			closedHandler = () -> {
				if (exiting)
					ThrustShell.getShell().cleanup();
				f.accept(null);
			};
		}
	}

	public void onResponsive(Consumer<EventFields> f) {
		Events.setCallback(id, RESPONSIVE, f);
	}

	public void onUnResponsive(Consumer<EventFields> f) {
		Events.setCallback(id, UNRESPONSIVE, f);
	}

	public void onRendererCrashed(Consumer<EventFields> f) {
		Events.setCallback(id, WORKER_CRASHED, f);
	}

	public Integer getId() {
		return id;
	}

	public static CompletableFuture<Window> create(String rootUrl, String title, String iconPath, Size size) {
		String rootUrl_ = ofNullable(rootUrl).orElse("");
		String title_ = ofNullable(title).orElse("");
		String iconPath_ = ofNullable(iconPath).orElse("");
		Size size_ = ofNullable(size).orElse(DEFAULT_SIZE);
		List<Argument<?>> args = asList(rootUrl(rootUrl_), title(title_), iconPath(iconPath_), size(size_));
		int id = sendCommand(CREATE, EMPTY, of("window"), empty(), args);
		CompletableFuture<Integer> future = new CompletableFuture<>();
		MessageBox.addPromise(id, future);
		return future.thenApplyAsync(winId -> {
			MessageBox.removePromise(id);
			return new Window(winId, rootUrl_, size_, title_, iconPath_, empty());
		});
	}

	public static CompletableFuture<Window> create(String rootUrl) {
		return create(ofNullable(rootUrl).orElse(""), "", "", DEFAULT_SIZE);
	}
}
