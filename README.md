# java-thrust

[Thrust] bindings for Java

# How to use

Download latest Thrust binary release [here] and point to the thrustshell binary in application.conf
```
thrust_path="/Applications/ThrustShell.app/Contents/MacOS/ThrustShell"
```

# How to use

Run file Main.java in test folder

```java
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
```

# Author
daniel.garciamandillo@gmail.com


[Thrust]: <https://github.com/breach/thrust>
[here]: <https://github.com/breach/thrust/releases>
