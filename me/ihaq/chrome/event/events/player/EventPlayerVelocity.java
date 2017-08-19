package me.ihaq.chrome.event.events.player;

import me.ihaq.chrome.event.Event;

public class EventPlayerVelocity extends Event {

	public double mx, my;

	public EventPlayerVelocity(double x, double y) {
		this.mx = x;
		this.my = y;
	}

}
