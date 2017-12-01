package me.ihaq.chrome.event.events;

import me.ihaq.chrome.event.Event;

public class EventRender2D extends Event {

	public int width, height;

	public EventRender2D(int width, int height) {
		super(Type.PRE);
		this.width = width;
		this.height = height;
	}
}
