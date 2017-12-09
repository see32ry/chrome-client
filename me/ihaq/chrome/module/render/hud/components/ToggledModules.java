package me.ihaq.chrome.module.render.hud.components;

import java.util.ArrayList;

import me.ihaq.chrome.Chrome;
import me.ihaq.chrome.event.EventTarget;
import me.ihaq.chrome.event.events.EventRender2D;
import me.ihaq.chrome.module.Module;
import me.ihaq.chrome.module.render.hud.HUD;
import me.ihaq.chrome.utils.Colors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class ToggledModules {

    @EventTarget
    public void onRender(EventRender2D e) {

        if (!HUD.arrayList.getBooleanValue())
            return;
        
        FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
        ArrayList<Module> mods = Chrome.INSTANCE.MODULE_MANAGER.getToggledModules();

        mods.sort((o1, o2) -> fr.getStringWidth(o2.getName()) - fr.getStringWidth(o1.getName()));
        int y = 2;
        for (Module m : mods) {
            int mWidth = fr.getStringWidth(m.getName());
            fr.drawStringWithShadow(m.getName(), e.width - mWidth - 2, y, Colors.getColor());
            y += 9 + 2;
        }
    }

}
