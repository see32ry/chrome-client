package me.ihaq.chrome.event.events.misc;

import me.ihaq.chrome.event.Event;

public class EventKeyboard extends Event {

	private int k;

	public EventKeyboard(int k) {
		this.k = k;
	}

	public int getKey() {
		return this.k;
	}

}
