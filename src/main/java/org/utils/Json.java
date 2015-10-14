package org.utils;

public class Json {

	private String field;
	private Object content;

	public Json(String field, Object content) {
		this.field = field;
		this.content = content;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

}
