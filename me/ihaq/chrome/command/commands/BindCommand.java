package me.ihaq.chrome.command.commands;

import org.lwjgl.input.Keyboard;

import me.ihaq.chrome.Chrome;
import me.ihaq.chrome.command.Command;
import me.ihaq.chrome.module.Module;

public class BindCommand implements Command {

	@Override
	public boolean run(String[] args) {
		if (args.length == 3) {
			Module m = Chrome.INSTANCE.MODULE_MANAGER.getModule(args[1]);
			m.setKeyCode(Keyboard.getKeyIndex(args[2].toUpperCase()));
			Chrome.INSTANCE.tellPlayer(m.getName() + " has been bound to " + args[2] + ".");
			return true;
		}
		return false;
	}

	@Override
	public String usage() {
		return "USAGE: -bind [module] [key]";
	}

}
