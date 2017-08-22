package me.ihaq.chrome.module.render.hud.components;

import java.awt.Color;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import com.mojang.realmsclient.gui.ChatFormatting;

import me.ihaq.chrome.Chrome;
import me.ihaq.chrome.event.EventTarget;
import me.ihaq.chrome.event.events.misc.EventKeyboard;
import me.ihaq.chrome.event.events.render.EventRender2D;
import me.ihaq.chrome.module.Module;
import me.ihaq.chrome.module.Module.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class TabGUI {

	private FontRenderer fr;

	private ArrayList<Category> categoryValues;
	private int currentCategoryIndex;

	public TabGUI() {
		this.fr = Minecraft.getMinecraft().fontRendererObj;
		this.categoryValues = new ArrayList();
		this.currentCategoryIndex = 0;
		for (Category c : Module.Category.values()) {
			this.categoryValues.add(c);
		}
	}

	@EventTarget
	public void onRedner(EventRender2D e) {
		this.renderTopString(5, 5);
		int startX = 5;
		int startY = (5 + 9) + 2;
		Gui.drawRect(startX, startY, startX + this.getWidestCategory() + 5,
				startY + this.categoryValues.size() * (9 + 2), new Color(0, 0, 0, 190).getRGB());
		for (Category c : this.categoryValues) {
			if (this.getCurrentCategorry().equals(c)) {
				Gui.drawRect(startX + 1, startY, startX + this.getWidestCategory() + 5 - 1, startY + 9 + 2,
						new Color(51, 00, 10, 190).getRGB());
			}

			String name = c.name();
			fr.drawStringWithShadow(name.substring(0, 1).toUpperCase() + name.substring(1, name.length()).toLowerCase(),
					startX + 2 + (this.getCurrentCategorry().equals(c) ? 2 : 0), startY + 2, -1);
			startY += 9 + 2;
		}

	}

	private void renderTopString(int x, int y) {
		fr.drawStringWithShadow(ChatFormatting.WHITE + Chrome.INSTANCE.CLIENT_NAME + ChatFormatting.RESET + " v"
				+ +Chrome.INSTANCE.CLIENT_VERSION, x, y, new Color(67, 00, 99).getRGB());
	}

	private void up() {
		if (this.currentCategoryIndex > 0) {
			this.currentCategoryIndex--;
		} else if (this.currentCategoryIndex == 0) {
			this.currentCategoryIndex = this.categoryValues.size() - 1;
		}

	}

	private void down() {
		if (this.currentCategoryIndex < this.categoryValues.size() - 1) {
			this.currentCategoryIndex++;
		} else if (this.currentCategoryIndex == this.categoryValues.size() - 1) {
			this.currentCategoryIndex = 0;
		}
	}

	private void right() {

	}

	private void left() {

	}

	@EventTarget
	public void onKey(EventKeyboard e) {
		switch (e.getKey()) {
		case Keyboard.KEY_UP:
			this.up();
			break;
		case Keyboard.KEY_DOWN:
			this.down();
			break;
		case Keyboard.KEY_RIGHT:
			this.right();
			break;
		case Keyboard.KEY_LEFT:
			this.left();
			break;
		case Keyboard.KEY_RETURN:
			this.right();
			break;
		}
	}

	private Category getCurrentCategorry() {
		return this.categoryValues.get(this.currentCategoryIndex);
	}

	private int getWidestCategory() {
		int width = 0;
		for (Category c : this.categoryValues) {
			String name = c.name();
			int cWidth = fr.getStringWidth(
					name.substring(0, 1).toUpperCase() + name.substring(1, name.length()).toLowerCase());
			if (cWidth > width) {
				width = cWidth;
			}
		}
		return width;
	}

}
