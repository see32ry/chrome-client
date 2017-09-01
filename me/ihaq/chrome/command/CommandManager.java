package me.ihaq.chrome.command;

import java.util.HashMap;
import java.util.Map;

import me.ihaq.chrome.Chrome;
import me.ihaq.chrome.command.commands.BindCommand;
import me.ihaq.chrome.command.commands.HelpCommand;

public class CommandManager {

	private HashMap<String[], Command> commands;
	private String prefix;

	public CommandManager() {
		commands = new HashMap();
		prefix = "-";
	}

	public void loadCommands() {
		commands.put(new String[] { "help", "h" }, new HelpCommand());
		commands.put(new String[] { "bind", "b" }, new BindCommand());
	}

	public boolean processCommand(String rawMessage) {
		if (!rawMessage.startsWith(prefix)) {
			return false;
		}

		boolean safe = rawMessage.split(prefix).length > 1;
		if (safe) {
			String beheaded = rawMessage.split(prefix)[1];
			String[] args = beheaded.split(" ");
			Command command = getCommand(args[0]);
			if (command != null) {
				if (!command.run(args)) {
					Chrome.INSTANCE.tellPlayer(command.usage());
				}
			} else {
				Chrome.INSTANCE.tellPlayer("Try -help.");
			}
		} else {
			Chrome.INSTANCE.tellPlayer("Try -help.");
		}

		return true;
	}

	private Command getCommand(String name) {
		for (Map.Entry entry : commands.entrySet()) {
			String[] key = (String[]) entry.getKey();
			for (String s : key) {
				if (s.equalsIgnoreCase(name)) {
					return (Command) entry.getValue();
				}
			}

		}
		return null;
	}
	
	public HashMap<String[], Command> getCommands(){
		return commands;
	}

}
