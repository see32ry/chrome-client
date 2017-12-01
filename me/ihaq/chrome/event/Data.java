package me.ihaq.chrome.event;

import java.lang.reflect.Method;

public class Data {

	public Object source;
	public Method target;

	public Data(Object source, Method target) {
		this.source = source;
		this.target = target;
	}

}
