package me.ihaq.chrome.setting;

import java.util.ArrayList;

import me.ihaq.chrome.module.Module;

public class SettingManager {

	private ArrayList<Setting> settings;

	public SettingManager() {
		this.settings = new ArrayList();
	}

	public void addSetting(Setting s) {
		this.settings.add(s);
	}

	public Setting getSetting(Module m, String name) {
		for (Setting s : this.settings) {
			if (s.getModule().equals(m) && s.getName().equalsIgnoreCase(name)) {
				return s;
			}
		}
		return null;
	}

	public ArrayList<Setting> getSettings() {
		return this.settings;
	}

	public ArrayList<Setting> getSettingsForModule(Module m) {
		ArrayList<Setting> settings = new ArrayList();
		for (Setting s : this.settings) {
			if (s.getModule().equals(m)) {
				settings.add(s);
			}
		}

		if (settings.isEmpty()) {
			return null;
		}
		return settings;
	}

}
