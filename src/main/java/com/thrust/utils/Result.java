package com.thrust.utils;

import static java.util.Optional.ofNullable;

import java.util.Optional;

public final class Result {
	private final Integer _target;
	private final Size size;
	private final Position position;
	private final Boolean maximize;
	private final Boolean kiosk;
	private final Boolean minimized;
	private final Boolean fullScreen;
	private final Boolean devToolsOpened;
	private final Boolean closed;
	
	Result(Integer target, Size size, Position position,
			Boolean maximize, Boolean kiosk, Boolean minimized,
			Boolean fullScreen, Boolean devToolsOpened, Boolean closed) {
		this._target = target;
		this.size = size;
		this.position = position;
		this.maximize = maximize;
		this.kiosk = kiosk;
		this.minimized = minimized;
		this.fullScreen = fullScreen;
		this.devToolsOpened = devToolsOpened;
		this.closed = closed;
	}
	
	public Optional<Integer> getTarget() {
		return ofNullable(_target);
	}
	
	public Optional<Size> getSize() {
		return ofNullable(size);
	}
	
	public Optional<Position> getPosition() {
		return ofNullable(position);
	}
	
	public Optional<Boolean> getMaximize() {
		return ofNullable(maximize);
	}
	
	public Optional<Boolean> getKiosk() {
		return ofNullable(kiosk);
	}
	
	public Optional<Boolean> getMinimized() {
		return ofNullable(minimized);
	}
	
	public Optional<Boolean> getFullScreen() {
		return ofNullable(fullScreen);
	}
	
	public Optional<Boolean> getDevToolsOpened() {
		return ofNullable(devToolsOpened);
	}
	
	public Optional<Boolean> getClosed() {
		return ofNullable(closed);
	}
	
	@Override
	public String toString() {
		return "Result [target=" + _target + ", size=" + size + ", position=" + position + ", maximize=" + maximize
				+ ", kiosk=" + kiosk + ", minimized=" + minimized + ", fullScreen=" + fullScreen + ", devToolsOpened="
				+ devToolsOpened + ", closed=" + closed + "]";
	}
	
}
