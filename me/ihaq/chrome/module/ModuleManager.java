package me.ihaq.chrome.module;

import me.ihaq.chrome.Chrome;
import me.ihaq.chrome.event.EventTarget;
import me.ihaq.chrome.event.events.EventKeyboard;
import me.ihaq.chrome.module.render.FullBright;
import me.ihaq.chrome.module.render.hud.HUD;

import java.util.ArrayList;

public class ModuleManager {

    /**
     * The ArrayList that holds all the modules.
     **/
    private ArrayList<Module> mods;

    public ModuleManager() {
        mods = new ArrayList<Module>();

        Chrome.INSTANCE.EVENT_MANAGER.register(this);
    }

    /**
     * Loads all the modules.
     **/
    public void loadMods() {
        addModule(new HUD());
        addModule(new FullBright());
    }

    /**
     * A methods that allows you to add a module to the array of all the modules.
     **/
    private void addModule(Module m) {
        mods.add(m);
    }

    /**
     * Returns all the modules.
     **/
    public ArrayList<Module> getMods() {
        return mods;
    }

    @EventTarget
    public void onKey(EventKeyboard eventKeyBoard) {
        for (Module mod : mods) {
            if (mod.getKeyCode() == eventKeyBoard.getKey())
                mod.toggle();
        }
    }

    /**
     * Goes through all the modules and returns an array of all the toggled modules.
     **/
    public ArrayList<Module> getToggledMods() {
        ArrayList<Module> mods = new ArrayList<Module>();
        for (Module m : mods) {
            if (m.isToggled())
                mods.add(m);
        }
        return mods;
    }

    /**
     * Tries to get the module by name, if none found it returns null.
     **/
    public Module getModule(String name) {
        for (Module m : mods) {
            if (m.getName().equalsIgnoreCase(name))
                return m;
        }
        return null;
    }

    /**
     * Tries to get the module by class, in none found it returns null.
     **/
    public Module getModule(Class<? extends Module> clazz) {
        for (Module m : mods) {
            if (m.getClass() == clazz)
                return m;
        }
        return null;
    }

}
