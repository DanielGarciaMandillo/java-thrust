package org.thrust_java;

import org.thrust_java.Sender.WinId;

/**
 * 
 * Window SOLO GETTERS Y SETTERS
 *
 */

public class Window {

	private WinId id;
	private String root_url;
	private int[] size;
	private String title;
	private String icon_path;
	private Integer session_id;

	public WinId getId() {
		return id;
	}

	public void setId(WinId id) {
		this.id = id;
	}

	public String getRoot_url() {
		return root_url;
	}

	public void setRoot_url(String root_url) {
		this.root_url = root_url;
	}

	public int[] getSize() {
		return size;
	}

	public void setSize(int[] size) {
		this.size = size;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIcon_path() {
		return icon_path;
	}

	public void setIcon_path(String icon_path) {
		this.icon_path = icon_path;
	}

	public Integer getSession_id() {
		return session_id;
	}

	public void setSession_id(Integer session_id) {
		this.session_id = session_id;
	}

	public static void create(String string) {
		// TODO Auto-generated method stub
		
	}

}
