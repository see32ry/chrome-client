package me.ihaq.chrome.module;

import java.util.ArrayList;

import me.ihaq.chrome.module.mods.render.FullBright;
import me.ihaq.chrome.module.mods.render.HUD;

public class ModuleManager {

	private ArrayList<Module> mods;

	public ModuleManager() {
		this.mods = new ArrayList();
	}

	public void loadMods() {
		this.addModule(new HUD());
		this.addModule(new FullBright());
	}

	private void addModule(Module m) {
		this.mods.add(m);
	}

	public ArrayList<Module> getMods() {
		return this.mods;
	}

	public ArrayList<Module> getToggledMods() {
		ArrayList<Module> mods = new ArrayList();
		this.mods.forEach(m -> {
			if (m.isToggled())
				mods.add(m);
		});
		return mods;
	}

	public Module getModule(String name) {
		for (Module m : this.mods) {
			if (m.getName().equalsIgnoreCase(name))
				return m;
		}
		return null;
	}

	public Module getModule(Class<? extends Module> mods) {
		for (Module m : this.mods) {
			if (m.getClass() == mods)
				return m;
		}
		return null;
	}

}
