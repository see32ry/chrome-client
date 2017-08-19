package me.ihaq.chrome;

import org.lwjgl.opengl.Display;

import me.ihaq.chrome.event.EventManager;

public class Chrome {

	public static Chrome INSTANCE = new Chrome();

	public final double CLIENT_VERSION = 1.0;
	public final String CLIENT_NAME = "Chrome";

	public EventManager EVENT_MANAGER;

	public void onEnable() {
		EVENT_MANAGER = new EventManager();
		Display.setTitle(CLIENT_NAME + " | " + CLIENT_VERSION);
	}

	public void onDisable() {

	}

}
