package me.ihaq.chrome.module.render.hud;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import me.ihaq.chrome.Chrome;
import me.ihaq.chrome.event.EventTarget;
import me.ihaq.chrome.event.events.render.EventRender2D;
import me.ihaq.chrome.module.Module;
import me.ihaq.chrome.module.render.hud.components.Arraylist;
import me.ihaq.chrome.module.render.hud.components.TabGUI;
import me.ihaq.chrome.setting.Setting;
import me.ihaq.chrome.utils.Colors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class HUD extends Module {

	private Arraylist ar;
	private TabGUI tab;

	public HUD() {
		super("HUD", Keyboard.KEY_F, Category.RENDER);
		Chrome.INSTANCE.SETTING_MANAGER.addSetting(new Setting(this, "ArrayList", true));
		Chrome.INSTANCE.SETTING_MANAGER.addSetting(new Setting(this, "TabGUI", true));
		this.ar = new Arraylist();
		this.tab = new TabGUI();
	}

	public void onEnable() {
		super.onEnable();
		Chrome.INSTANCE.EVENT_MANAGER.register(ar);
		Chrome.INSTANCE.EVENT_MANAGER.register(tab);
	}

	public void onDisable() {
		super.onDisable();
		Chrome.INSTANCE.EVENT_MANAGER.unregister(ar);
		Chrome.INSTANCE.EVENT_MANAGER.unregister(tab);
	}


}
