package me.ihaq.chrome.module.render;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import me.ihaq.chrome.Chrome;
import me.ihaq.chrome.event.EventTarget;
import me.ihaq.chrome.event.events.render.EventRender2D;
import me.ihaq.chrome.module.Module;
import me.ihaq.chrome.setting.Setting;
import me.ihaq.chrome.utils.Colors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class HUD extends Module {

	private Setting arraylist;

	public HUD() {
		super("HUD", Keyboard.KEY_F, Category.RENDER);
		Chrome.INSTANCE.SETTING_MANAGER.addSetting(this.arraylist = new Setting(this, "ArrayList", false));
	}

	public void onEnable() {
		super.onEnable();
	}

	public void onDisable() {
		super.onDisable();
	}

	@EventTarget
	public void onRender2D(EventRender2D e) {

		fr.drawStringWithShadow(Chrome.INSTANCE.CLIENT_NAME + " | " + Chrome.INSTANCE.CLIENT_VERSION, 5, 5,
				Colors.getColor());

		if (this.arraylist.getBooleanValue()) {
			renderArrayList(e.width);
		}

	}

	private void renderArrayList(int width) {
		FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
		ArrayList<Module> mods = Chrome.INSTANCE.MODULE_MANAGER.getToggledMods();

		mods.sort((o1, o2) -> fr.getStringWidth(o2.getName()) - fr.getStringWidth(o1.getName()));
		int y = 2;
		for (Module m : mods) {
			int mWidth = fr.getStringWidth(m.getName());
			fr.drawStringWithShadow(m.getName(), width - mWidth - 2, y, Colors.getColor());
			y += 9 + 2;
		}
	}

}
