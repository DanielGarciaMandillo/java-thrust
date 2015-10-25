package org.thrust_java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

import org.thrust_java.Arguments.Argument;
import org.thrust_java.Arguments.CookieStore;
import org.thrust_java.Arguments.OffTheRecord;
import org.thrust_java.Arguments.Path;
import org.thrust_java.Arguments.Url;
import org.thrust_java.RemoteArguments.Cookie;
import org.thrust_java.Sender.SessionId;
import org.thrust_java.ThrustShell.MessageId;

/**
 * Session TERMINADO FALTA TODO
 *
 */
public class Session {

	private SessionId id;
	private Boolean offTheRecord;
	private String path;
	private Boolean cookieStore;

	private Sender sender = new Sender();
	private MessageBox messageBox = new MessageBox();

	public Session(SessionId id, Boolean offTheRecord, String path, Boolean cookieStore) {
		this.id = id;
		this.offTheRecord = offTheRecord;
		this.path = path;
		this.cookieStore = cookieStore;
	}

	public Session() {

	}

	public SessionId getId() {
		return id;
	}

	public void setId(SessionId id) {
		this.id = id;
	}

	public Boolean getOffTheRecord() {
		return offTheRecord;
	}

	public void setOffTheRecord(Boolean offTheRecord) {
		this.offTheRecord = offTheRecord;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Boolean getCookieStore() {
		return cookieStore;
	}

	public void setCookieStore(Boolean cookieStore) {
		this.cookieStore = cookieStore;
	}

	private ConcurrentHashMap<String, Set<Cookie>> cookies;

	public void visitedlinkAdd(String url) throws IOException {
		List<Argument> args = new ArrayList<>();
		Url arg1 = new Arguments().getUrl();
		arg1.setParam(url);
		args.add(arg1);

		sender.sendCommand(new Actions().getCall(), new Methods().getVisitedLinkAdd(), null, id, args);
	}

	public void visitedlinkClear() throws IOException {
		sender.sendCommand(new Actions().getCall(), new Methods().getVisitedLinkClear(), null, id,
				new ArrayList<Argument>());
	}

	// TODO repasar el metodo
	public Future isOffTherecord() throws IOException {
		MessageId mid = sender.sendCommand(new Actions().getCall(), new Methods().getIsOffTheRecord(), null, id,
				new ArrayList<Argument>());
		Future f = (Future) new Session();
		messageBox.addPromise(mid, f);
		return f;
	}

	public void cookiesLoadForKey(String domain) {
		cookies.get(domain);
	}

	public void cookies_flush() {
	}

	// TODO como recorrer? que añadimos
	// def cookies_add(ck: Cookie) = {
	// cookies.synchronized {
	// cookies.get(ck.domain).foreach(_ += ck)
	// }
	// }
	public void cookies_add(Cookie ck) {
		Set<Cookie> cks = cookies.get(ck.getDomain());
		for (Cookie e : cks) {
		}
	}

	public void cookies_delete(Cookie cookie) {
		cookies.remove(cookie);
	}

	// TODO como recorrer? que eliminar
	//
	// def cookies_update_access_time(c: Cookie) = {
	// cookies.synchronized {
	// cookies.get(c.domain).map { s =>
	// s.remove(c)
	// s += c.copy(last_access = new Date())
	// }
	// }
	// }
	public void cookies_update_access_time(Cookie cookie) {
		Set<Cookie> cks = cookies.get(cookie.getDomain());
		for (Cookie c : cks) {

		}

	}

	// TODO Esto? No tiene metodo ni atributo ni nada, es un bloque de codigo
	// {
	// RemoteMethods.setCallback(id, COOKIES_LOAD_FOR_KEY, args =>
	// cookiesLoadForKey(args.key.get))
	// RemoteMethods.setCallback(id, COOKIES_LOAD, args =>
	// cookies_add(args.cookie.get))
	// RemoteMethods.setCallback(id, COOKIES_UPDATE_ACCESS_TIME, args =>
	// cookies_update_access_time(args.cookie.get))
	// RemoteMethods.setCallback(id, COOKIES_DELETE, args =>
	// cookies_delete(args.cookie.get))
	//
	// }

	public void create(Boolean offTheRecord, String path, Boolean cookieStore) throws IOException {
		List<Argument> args = new ArrayList<>();

		OffTheRecord arg1 = new Arguments().getOffTheRecord();
		arg1.setParam(offTheRecord);

		Path arg2 = new Arguments().getPath();
		arg2.setParam(path);

		CookieStore arg3 = new Arguments().getCookieStore();
		arg3.setParam(cookieStore);

		args.add(arg1);
		args.add(arg2);
		args.add(arg3);

		sender.sendCommand(new Actions().getCreate(), new Methods().getEmpty(), "session", null, args);

		// TODO promesas y futuros. MSG ID?
		// val p = Promise[Int]
		// val f = p.future
		// MessageBox.addPromise(id, p)
		// f.map { sessionId =>
		// MessageBox.removePromise(id)
		// Session(SessionId(sessionId), offTheRecord, path, cookieStore)
		// }
		// }
		// }
		Session session = new Session();
		new Session(session.getId(), offTheRecord, path, cookieStore);
	}

}
