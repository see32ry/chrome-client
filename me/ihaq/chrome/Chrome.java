package me.ihaq.chrome;

import org.lwjgl.opengl.Display;

import me.ihaq.chrome.event.EventManager;
import me.ihaq.chrome.event.EventTarget;
import me.ihaq.chrome.event.events.misc.EventKeyboard;
import me.ihaq.chrome.module.ModuleManager;

public class Chrome {

	public static Chrome INSTANCE = new Chrome();

	public final double CLIENT_VERSION = 1.0;
	public final String CLIENT_NAME = "Chrome";

	public EventManager EVENT_MANAGER;
	public ModuleManager MODULE_MANAGER;

	public void onEnable() {
		EVENT_MANAGER = new EventManager();
		MODULE_MANAGER = new ModuleManager();
		EVENT_MANAGER.register(this);
		Display.setTitle(CLIENT_NAME + " | " + CLIENT_VERSION);

		MODULE_MANAGER.loadMods();
	}

	public void onDisable() {

	}

	@EventTarget
	public void onKey(EventKeyboard e) {
		MODULE_MANAGER.getMods().forEach(m -> {
			if (m.getKeyCode() == e.getKey())
				m.toggle();
		});
	}

}
