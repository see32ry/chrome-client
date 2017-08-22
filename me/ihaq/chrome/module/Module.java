package me.ihaq.chrome.module;

import me.ihaq.chrome.Chrome;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;

public class Module {

	protected static Minecraft mc = Minecraft.getMinecraft();
	protected static EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
	protected static FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;

	private String name;
	private int keyCode;
	private boolean toggled;
	private Category category;

	public Module(String name, int keyCode, Category category) {
		this.name = name;
		this.keyCode = keyCode;
		this.category = category;
		this.toggled = false;
	}

	public enum Category {
		COMBAT, MOVEMENT, RENDER, WORLD, PLAYER
	}

	public void toggle() {
		this.toggled = !this.toggled;
		if (this.toggled) {
			onEnable();
		} else {
			onDisable();
		}
	}

	public void onEnable() {
		Chrome.INSTANCE.EVENT_MANAGER.register(this);
	}

	public void onDisable() {
		Chrome.INSTANCE.EVENT_MANAGER.unregister(this);
	}

	public boolean isToggled() {
		return this.toggled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
