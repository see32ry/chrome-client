package me.ihaq.chrome.event.events;

import me.ihaq.chrome.event.Event;

public class EventRender3D extends Event {

	public float particlTicks;

	public EventRender3D(float particlTicks) {
		super(Type.PRE);
		this.particlTicks = particlTicks;
	}

}
