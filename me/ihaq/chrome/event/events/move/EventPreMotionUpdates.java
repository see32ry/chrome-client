package me.ihaq.chrome.event.events.move;

import me.ihaq.chrome.event.Event;

public class EventPreMotionUpdates extends Event {

	private boolean cancel;
	public float yaw, pitch;
	public double y;

	public EventPreMotionUpdates(float yaw, float pitch, double y) {
		this.yaw = yaw;
		this.pitch = pitch;
		this.y = y;
	}

}
