package org.thrust_java;

import org.junit.Test;
import org.thrust_java.Arguments.Arg_CommandId;
import org.thrust_java.Arguments.CookieStore;
import org.thrust_java.Arguments.Focus;
import org.thrust_java.Arguments.IconPath;
import org.thrust_java.Arguments.OffTheRecord;
import org.thrust_java.Arguments.Position;
import org.thrust_java.Arguments.RootUrl;
import org.thrust_java.Arguments.Size;
import org.thrust_java.Arguments.Title;
import org.thrust_java.Arguments.Url;
import org.thrust_java.Arguments.Value;
import org.utils.Json;

import junit.framework.Assert;

public class ArgumentsTest {

	@Test
	public void argumentRootUrlTest() {

		RootUrl rootUrl = new Arguments().getRootUrl();
		rootUrl.setParam("www.google.es");
		
		Json jsonResponse = Arguments.argumentsToJson(rootUrl);
		
		Assert.assertEquals("www.google.es", rootUrl.getParam());
		Assert.assertEquals("root_url", jsonResponse.getField());
	}
	
	@Test
	public void argumentFocusTest() {

		Focus focusTrue = new Arguments().getFocus();
		focusTrue.setParam(true);
		
		Json jsonResponseTrue = Arguments.argumentsToJson(focusTrue);
		
		Focus focusFalse = new Arguments().getFocus();
		focusFalse.setParam(false);
		
		Json jsonResponseFalse = Arguments.argumentsToJson(focusFalse);
		
		Assert.assertEquals(true, focusTrue.getParam());
		Assert.assertEquals("focus", jsonResponseTrue.getField());
		
		Assert.assertEquals(false, focusFalse.getParam());
		Assert.assertEquals("focus", jsonResponseFalse.getField());
		
	}
	
	@Test
	public void argumentTitleTest() {

		Title title = new Arguments().getTitle();
		title.setParam("titulo");
		
		Json jsonResponse = Arguments.argumentsToJson(title);
		
		Assert.assertEquals("titulo", title.getParam());
		Assert.assertEquals("title", jsonResponse.getField());
	}
	
	@Test
	public void argumentValueTest() {

		Value value = new Arguments().getValue();
		value.setParam(false);
		
		Json jsonResponse = Arguments.argumentsToJson(value);
		
		Assert.assertEquals(false, value.getParam());
		Assert.assertEquals("value", jsonResponse.getField());
	}
	
	@Test
	public void argumentCookieStoreTest() {

		CookieStore cookie = new Arguments().getCookieStore();
		cookie.setParam(true);
		
		Json jsonResponse = Arguments.argumentsToJson(cookie);
		
		Assert.assertEquals(true, cookie.getParam());
		Assert.assertEquals("cookie_store", jsonResponse.getField());
	}
	
	@Test
	public void argumentOffTheRecordTest() {

		OffTheRecord oof = new Arguments().getOffTheRecord();
		oof.setParam(true);
		
		Json jsonResponse = Arguments.argumentsToJson(oof);
		
		Assert.assertEquals(true, oof.getParam());
		Assert.assertEquals("off_the_record", jsonResponse.getField());
	}
	
	@Test
	public void argumentSizeTest() {

		Size size = new Arguments().getSize();
		size.setParam(3, 5);
		
		Json jsonResponse = Arguments.argumentsToJson(size);
		
		Assert.assertEquals(3, size.getWidth());
		Assert.assertEquals(5, size.getHeight());
		Assert.assertEquals("size", jsonResponse.getField());
	}
	
	@Test
	public void argumentPositionTest() {

		Position position = new Arguments().getPosition();
		position.setParam(800, 555);
		
		Json jsonResponse = Arguments.argumentsToJson(position);
		
		Assert.assertEquals(800, position.getX());
		Assert.assertEquals(555, position.getY());
		Assert.assertEquals("position", jsonResponse.getField());
	}
	
	@Test
	public void argumentIconPathTest() {

		IconPath iconPath = new Arguments().getIconPath();
		iconPath.setParam("/home/icon/path");
		
		Json jsonResponse = Arguments.argumentsToJson(iconPath);
		
		Assert.assertEquals("/home/icon/path", iconPath.getParam());
		Assert.assertEquals("icon_path", jsonResponse.getField());
	}
	
	@Test
	public void argumentUrlTest() {

		Url url = new Arguments().getUrl();
		url.setParam("www.urjc.es");
		
		Json jsonResponse = Arguments.argumentsToJson(url);
		
		Assert.assertEquals("www.urjc.es", url.getParam());
		Assert.assertEquals("url", jsonResponse.getField());
	}
	
	@Test
	public void argumentArgCommandIdTest() {

		Arg_CommandId id = new Arguments().getArgCommandId();
		id.setParam(12);
		
		Json jsonResponse = Arguments.argumentsToJson(id);
		
		Assert.assertEquals(12, id.getParam());
		Assert.assertEquals("command_id", jsonResponse.getField());
	}
	
}
