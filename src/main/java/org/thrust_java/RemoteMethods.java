package org.thrust_java;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

import org.thrust_java.Sender.TargetId;
import org.utils.IntegerRemoteMethod;

/**
 * RemoteMethods : TERMINADO EXCEPTO 1 TODO
 *
 */
public class RemoteMethods {

	private ConcurrentHashMap<IntegerRemoteMethod, Callable> handlersMap;

	public RemoteMethod fromString(String s) {
		switch (s) {
		case "cookies_load":
			return getCookiesLoad();
		case "cookies_load_for_key":
			return getCookiesLoadForKey();
		case "cookies_flush":
			return getCookiesFlush();
		case "cookies_add":
			return getCookiesAdd();
		case "cookies_update_access_time":
			return getCookiesUpdateAccessTime();
		case "cookies_delete":
			return getCookiesDelete();
		case "cookies_force_keep_session_state":
			return getCookiesForceKeepSessionState();
		default:
			return null;
		}
	}

	public class RemoteMethod {
	}

	public class COOKIES_LOAD extends RemoteMethod {
		public COOKIES_LOAD() {
		}
	}

	public class COOKIES_LOAD_FOR_KEY extends RemoteMethod {
		public COOKIES_LOAD_FOR_KEY() {
		}
	}

	public class COOKIES_FLUSH extends RemoteMethod {
		public COOKIES_FLUSH() {
		}
	}

	public class COOKIES_ADD extends RemoteMethod {
		public COOKIES_ADD() {
		}
	}

	public class COOKIES_UPDATE_ACCESS_TIME extends RemoteMethod {
		public COOKIES_UPDATE_ACCESS_TIME() {
		}
	}

	public class COOKIES_DELETE extends RemoteMethod {
		public COOKIES_DELETE() {
		}
	}

	public class COOKIES_FORCE_KEEP_SESSION_STATE extends RemoteMethod {
		public COOKIES_FORCE_KEEP_SESSION_STATE() {
		}
	}

	public COOKIES_LOAD getCookiesLoad() {
		return new COOKIES_LOAD();
	}

	public COOKIES_LOAD_FOR_KEY getCookiesLoadForKey() {
		return new COOKIES_LOAD_FOR_KEY();
	}

	public COOKIES_FLUSH getCookiesFlush() {
		return new COOKIES_FLUSH();
	}

	public COOKIES_ADD getCookiesAdd() {
		return new COOKIES_ADD();
	}

	public COOKIES_UPDATE_ACCESS_TIME getCookiesUpdateAccessTime() {
		return new COOKIES_UPDATE_ACCESS_TIME();
	}

	public COOKIES_DELETE getCookiesDelete() {
		return new COOKIES_DELETE();
	}

	public COOKIES_FORCE_KEEP_SESSION_STATE getCookiesForceKeepSessionState() {
		return new COOKIES_FORCE_KEEP_SESSION_STATE();
	}

	public void callback(Integer id, RemoteMethod rm, Arguments args) {

		// TODO COMO?
		// def callback(id: Int, rm: RemoteMethod, args: Args): Unit = {
		// Future {
		// handlersMap.get((id, rm)).foreach(_(args))
		// }
		// }
		IntegerRemoteMethod key = new IntegerRemoteMethod(id, rm);
		handlersMap.get(key);
	}

	public void setCallback(TargetId id, RemoteMethod rm, Callable function) {
		IntegerRemoteMethod key = new IntegerRemoteMethod(id.getId(), rm);
		handlersMap.replace(key, function);
	}
}
