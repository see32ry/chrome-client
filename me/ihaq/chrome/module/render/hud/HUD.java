package me.ihaq.chrome.module.render.hud;

import me.ihaq.chrome.Chrome;
import me.ihaq.chrome.module.Category;
import me.ihaq.chrome.module.Module;
import me.ihaq.chrome.module.render.hud.components.TabGUI;
import me.ihaq.chrome.module.render.hud.components.ToggledModules;
import me.ihaq.chrome.setting.Setting;
import org.lwjgl.input.Keyboard;

public class HUD extends Module {

    private ToggledModules ar;
    private TabGUI tab;

    public static Setting arrayList;
    public static Setting tabGui;

    public HUD() {
        super("HUD", Keyboard.KEY_F, Category.RENDER);

        Chrome.INSTANCE.SETTING_MANAGER.addSetting(arrayList = (new Setting(this, "ArrayList", true)));
        Chrome.INSTANCE.SETTING_MANAGER.addSetting(tabGui = (new Setting(this, "TabGUI", true)));

        ar = new ToggledModules();
        tab = new TabGUI();
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
