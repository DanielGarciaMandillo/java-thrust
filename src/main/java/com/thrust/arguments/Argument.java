package com.thrust.arguments;

import com.thrust.replies.Position;
import com.thrust.replies.Size;

public class Argument<T> {

	private final String name;
	private final T value;

	Argument(String name, T value) {
		this.name = name;
		this.value = value;
	}

	public static <T> Argument<T> argument(String field, T v) {
		return new Argument<>(field, v);
	}

	public static Argument<String> rootUrl(final String v) {
		return argument("root_url", v);
	}

	public static Argument<Boolean> focus(final boolean v) {
		return argument("focus", v);
	}

	public static Argument<String> title(final String v) {
		return argument("title", v);
	}

	public static Argument<Boolean> value(final boolean v) {
		return argument("value", v);
	}

	public static Argument<Boolean> cookieStore(final boolean v) {
		return argument("cookie_store", v);
	}

	public static Argument<Boolean> offTheRecord(final boolean v) {
		return argument("off_the_record", v);
	}

	public static Argument<Size> size(final int width, final int height) {
		return argument("size", new Size(width, height));
	}

	public static Argument<Size> size(final Size size) {
		return size(size.getWidth(), size.getHeight());
	}

	public static Argument<Position> position(final int x, final int y) {
		return argument("position", new Position(x, y));
	}

	public static Argument<Position> position(final Position position) {
		return position(position.getX(), position.getY());
	}

	public static Argument<String> iconPath(final String v) {
		return argument("icon_path", v);
	}

	public static Argument<String> url(final String v) {
		return argument("url", v);
	}

	public static Argument<Integer> argCommandId(final int id) {
		return argument("command_id", id);
	}

	public static Argument<String> label(final String v) {
		return argument("label", v);
	}

	public static Argument<Integer> argGroupId(final int id) {
		return argument("group_id", id);
	}

	public static Argument<Integer> argMenuId(final int id) {
		return argument("menu_id", id);
	}

	public static Argument<String> accelerator(final String v) {
		return argument("accelerator", v);
	}

	public static Argument<Integer> argWindowId(final int id) {
		return argument("window_id", id);
	}

	public static Argument<String> path(final String v) {
		return argument("path", v);
	}

	public String getName() {
		return name;
	}

	public T getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Argument [name=" + name + ", value=" + value + "]";
	}

}
