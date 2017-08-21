package me.ihaq.chrome;

import org.lwjgl.opengl.Display;

import com.mojang.realmsclient.gui.ChatFormatting;

import me.ihaq.chrome.event.EventManager;
import me.ihaq.chrome.event.EventTarget;
import me.ihaq.chrome.event.events.misc.EventKeyboard;
import me.ihaq.chrome.module.Module;
import me.ihaq.chrome.module.ModuleManager;
import me.ihaq.chrome.setting.SettingManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class Chrome {

	public static Chrome INSTANCE = new Chrome();

	public final double CLIENT_VERSION = 1.0;
	public final String CLIENT_NAME = "Chrome";

	public EventManager EVENT_MANAGER;
	public ModuleManager MODULE_MANAGER;
	public SettingManager SETTING_MANAGER;

	public void onEnable() {
		EVENT_MANAGER = new EventManager();
		MODULE_MANAGER = new ModuleManager();
		SETTING_MANAGER = new SettingManager();

		EVENT_MANAGER.register(this);

		Display.setTitle(CLIENT_NAME + " | " + CLIENT_VERSION);

		MODULE_MANAGER.loadMods();
	}

	public void onDisable() {

	}

	public void tellPlayer(String text) {
		Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(
				ChatFormatting.WHITE + "[" + ChatFormatting.RED + CLIENT_NAME + ChatFormatting.WHITE + "] " + text));
	}

	@EventTarget
	public void onKey(EventKeyboard e) {
		for (Module m : MODULE_MANAGER.getMods()) {
			if (m.getKeyCode() == e.getKey()) {
				m.toggle();
			}
		}
	}

}
