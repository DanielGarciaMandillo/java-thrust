package com.thrust.utils;

/**
 * Created by Admin on 8/12/15.
 */
public class Size {
	private final int width;
	private final int height;
	
	public Size(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	@Override
	public String toString() {
		return "Size [width=" + width + ", height=" + height + "]";
	}
	
}
