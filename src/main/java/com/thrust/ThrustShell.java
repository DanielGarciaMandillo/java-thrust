package com.thrust;

import static java.util.Optional.ofNullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.google.gson.Gson;
import com.thrust.event.Event;
import com.thrust.event.EventReply;
import com.thrust.event.Events;
import com.thrust.replies.Reply;
import com.thrust.replies.Result;
import com.thrusts.remote.RemoteMethod;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public final class ThrustShell {
	private static ThrustShell shell;
	private final Process process = initProcess();
	public final BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
	public final OutputStream out = process.getOutputStream();

	private ThrustShell() {
		startThread();
	}

	public static ThrustShell getShell() {
		if (shell == null)
			shell = new ThrustShell();
		return shell;
	}

	private Process initProcess() {
		try {
			Config config = ConfigFactory.load();
			ProcessBuilder pb = new ProcessBuilder(config.getString("thrust_path"));
			pb.redirectErrorStream(true);
			return pb.start();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	private void startThread() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					boolean continue_ = true;
					while (continue_) {
						Optional<String> reply = ofNullable(in.readLine());
						System.out.println(reply);
						if (reply.isPresent()) {
							String r = reply.get();
							if (r.contains("reply")) {
								Reply rr = new Gson().fromJson(r, Reply.class);
								if (rr.getMethod().isPresent())
									handleRemoteMethods(rr);
								else
									handleReply(rr);
							} else if (r.contains("event")) {
								handleEvent(r);
							}
						} else {
							continue_ = false;
						}
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}).start();
	}

	public void handleEvent(String event) {
		EventReply reply = new Gson().fromJson(event, EventReply.class);
		Events.callback(reply.getTarget(), Event.fromString(reply.getType()), reply.getEf());
	}

	public void handleReply(Reply reply) {
		Result res = reply.getResult();
		List<Optional<Boolean>> l = Arrays.asList(res.getClosed(), res.getDevToolsOpened(), res.getFullScreen(),
				res.getKiosk(), res.getMaximize(), res.getMinimized());
		System.out.println(res);
		final CompletableFuture promise = MessageBox.getPromise(reply.getId());
		res.getTarget().ifPresent(x -> promise.complete(x));
		l.stream().filter(Optional::isPresent).findFirst().ifPresent(h -> promise.complete(h.get()));
		res.getPosition().ifPresent(p -> promise.complete(p));
		res.getSize().ifPresent(s -> promise.complete(s));
		System.out.println("-----------Exitinig handleReply -----------");
	}

	public void handleRemoteMethods(Reply reply) {
		Optional<RemoteMethod> method = reply.getMethod();
	}

	public void cleanup() {
		process.destroy();
	}
}
