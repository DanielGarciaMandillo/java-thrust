package com.thrust;

public final class Method {
	public static final Method EMPTY = new Method("");
	public static final Method SHOW = new Method("show");
	public static final Method FOCUS = new Method("focus");
	public static final Method MAXIMIZE = new Method("maximize");
	public static final Method MINIMIZE = new Method("minimize");
	public static final Method RESTORE = new Method("restore");
	public static final Method SET_TITLE = new Method("set_title");
	public static final Method SET_FULLSCREEN = new Method("set_fullscreen");
	public static final Method SET_KIOSK = new Method("set_kiosk");
	public static final Method OPEN_DEV_TOOLS = new Method("open_devtools");
	public static final Method CLOSE_DEV_TOOLS = new Method("close_devtools");
	public static final Method MOVE = new Method("move");
	public static final Method RESIZE = new Method("resize");
	public static final Method IS_CLOSED = new Method("is_closed");
	public static final Method SIZE = new Method("size");
	public static final Method POSITION = new Method("position");
	public static final Method IS_MAXIMIZED = new Method("is_maximized");
	public static final Method IS_MINIMIZED = new Method("is_minimized");
	public static final Method IS_FULLSCREEN = new Method("is_fullscreen");
	public static final Method IS_KIOSKED = new Method("is_kiosked");
	public static final Method IS_DEV_TOOLS_OPENED = new Method("is_devtools_opened");
	public static final Method VISITED_LINK_ADD = new Method("visitedlink_add");
	public static final Method VISITED_LINK_CLEAR = new Method("visitedlink_clear");
	public static final Method PROXY_SET = new Method("proxy_set");
	public static final Method PROXY_CLEAR = new Method("proxy_clear");
	public static final Method IS_OFF_THE_RECORD = new Method("is_off_the_record");
	public static final Method ADD_ITEM = new Method("add_item");
	public static final Method ADD_CHECK_ITEM = new Method("add_check_item");
	public static final Method ADD_RADIO_ITEM = new Method("add_radio_item");
	public static final Method ADD_SEPARATOR = new Method("add_separator");
	public static final Method SET_CHECKED = new Method("set_checked");
	public static final Method SET_ENABLED = new Method("set_enabled");
	public static final Method SET_VISIBLE = new Method("set_visible");
	public static final Method SET_ACCELERATOR = new Method("set_accelerator");
	public static final Method ADD_SUBMENU = new Method("add_submenu");
	public static final Method CLEAR = new Method("clear");
	public static final Method POPUP = new Method("popup");
	public static final Method SET_APPLICATION_MENU = new Method("set_application_menu");

	private final String _method;

	public Method(String name) {
		this._method = name;
	}

	public String getName() {
		return _method;
	}

	@Override
	public String toString() {
		return "Method [_method=" + _method + "]";
	}

}
