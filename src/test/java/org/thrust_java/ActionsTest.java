package org.thrust_java;

import org.junit.Test;
import org.thrust_java.Actions.Call;
import org.thrust_java.Actions.Create;
import org.utils.Json;

import junit.framework.Assert;

public class ActionsTest {

	@Test
	public void actionCreateTest() {

		Create create = new Actions().getCreate();

		Json jsonResponse = Actions.actionToJson(create);

		Assert.assertEquals("_action", jsonResponse.getField());
		Assert.assertEquals("create", jsonResponse.getContent());
	}

	@Test
	public void actionCallTest() {

		Call call = new Actions().getCall();

		Json jsonResponse = Actions.actionToJson(call);

		Assert.assertEquals("_action", jsonResponse.getField());
		Assert.assertEquals("call", jsonResponse.getContent());
	}

}
