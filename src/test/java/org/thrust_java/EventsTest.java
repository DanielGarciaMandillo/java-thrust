package org.thrust_java;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Assert;
import org.junit.Test;
import org.thrust_java.Replies.EventFields;
import org.utils.IntegerEvent;

public class EventsTest {

	@Test
	public void eventsTest() {

		// Events events = new Events();
		// ConcurrentHashMap<IntegerEvent, Callable<Integer>> map =
		// events.getCallbackMap();
		//
		// Event eventBlur = new Events().getBlur();
		// IntegerEvent key = new IntegerEvent(5, eventBlur);
		//
		//
		// Callable<Integer> value = new Callable<Integer>(){
		// @Override
		// public Integer call(){
		// System.out.println("Task is running");
		// return new Integer(1);
		// }
		// };
		//
		// map.put(key, value);
		//
		// IntegerEvent noExpectedKey1 = new IntegerEvent(1, new
		// Events().getBlur());
		// IntegerEvent noExpectedKey2 = new IntegerEvent(5, new
		// Events().getFocus());
		// IntegerEvent noExpectedKey3 = new IntegerEvent(55, new
		// Events().getClosed());
		// Callable<Integer> expectedValue = map.get(key);
		//
		// Integer valor = null;
		// try {
		// valor = expectedValue.call();
		// } catch (Exception e) {
		// new Exception("Failed execution callable");
		// }
		//
		// Assert.assertEquals(value, expectedValue);
		// Assert.assertEquals(1, valor.intValue());
		// Assert.assertNotSame(key, noExpectedKey1);
		// Assert.assertNotSame(key, noExpectedKey2);
		// Assert.assertNotSame(key, noExpectedKey3);

		Events events = new Events();
		ConcurrentHashMap<IntegerEvent, EventFields> map = events.getCallbackMap();

		events.callback(1, events.getBlur(), new Replies().getEventFields());
		events.callback(2, events.getBlur(), new Replies().getEventFields());
		events.callback(3, events.getBlur(), new Replies().getEventFields());
		Assert.assertEquals(3, map.size());

		events.setCallback(3, events.getFocus(), new Replies().getEventFields());
		Assert.assertEquals(3, map.size());

		// TODO POR DEFINIR ELIMINAR POR WINDOW
		// events.removeForWindow(1);
		// Assert.assertEquals(2, map.size());

	}
}
