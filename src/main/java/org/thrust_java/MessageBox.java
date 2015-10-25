package org.thrust_java;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

import org.thrust_java.ThrustShell.MessageId;

/**
 * MessageBox TERMINADO
 *
 */
public class MessageBox {

	private ConcurrentHashMap<MessageId, Future<Integer>> promiseMap;

	public void addPromise(MessageId id, Future<Integer> f){
		promiseMap.put(id, f);
	}
	
	public void removePromise(MessageId id){
		promiseMap.remove(id);
	}
	
	public Future<Integer> getPromise(MessageId id){
		return getPromise(id);
	}
}
