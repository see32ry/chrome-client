package me.ihaq.chrome.module;

import java.util.ArrayList;

import me.ihaq.chrome.module.render.FullBright;
import me.ihaq.chrome.module.render.hud.HUD;

public class ModuleManager {

	/** The ArrayList that holds all the modules. **/
	private ArrayList<Module> mods;

	public ModuleManager() {
		this.mods = new ArrayList();
	}

	/** Loads all the modules. **/
	public void loadMods() {
		this.addModule(new HUD());
		this.addModule(new FullBright());
	}

	/**
	 * A methods that allows you to add a module to the array of all the modules.
	 **/
	private void addModule(Module m) {
		this.mods.add(m);
	}

	/** Returns all the modules. **/
	public ArrayList<Module> getMods() {
		return this.mods;
	}

	/**
	 * Goes through all the modules and returns an array of all the toggled modules.
	 **/
	public ArrayList<Module> getToggledMods() {
		ArrayList<Module> mods = new ArrayList();
		for (Module m : mods) {
			if (m.isToggled()) {
				mods.add(m);
			}
		}
		return mods;
	}

	/** Tries to get the module by name, if none found it returns null. **/
	public Module getModule(String name) {
		for (Module m : this.mods) {
			if (m.getName().equalsIgnoreCase(name))
				return m;
		}
		return null;
	}

	/** Tries to get the module by class, in none found it returns null. **/
	public Module getModule(Class<? extends Module> mods) {
		for (Module m : this.mods) {
			if (m.getClass() == mods)
				return m;
		}
		return null;
	}

}
