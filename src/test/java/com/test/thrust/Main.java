package com.test.thrust;

import com.thrust.Window;
import com.thrust.menu.Menu;
import com.thrust.menu.MenuItem;

public class Main {

	public static void main(String[] args) {
		Window.create("http://google.com").whenComplete((w, e) -> processWindow(w, e));
	}

	private static void processWindow(Window w, Throwable e) {
		w.show();
		w.maximize();
		w.focus(true);
		w.onBlur(x -> System.out.println("we were blurred"));
		w.onFocus(x -> System.out.println("we were focused"));
		w.onClosed(x ->{
			System.out.println("we were closed");
			System.exit(0);
		});
	}
}
