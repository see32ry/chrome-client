package me.ihaq.chrome.command.commands;

import me.ihaq.chrome.Chrome;
import me.ihaq.chrome.command.Command;
import me.ihaq.chrome.utils.PlayerUtils;

public class HelpCommand implements Command {

    @Override
    public boolean run(String[] args) {
        PlayerUtils.tellPlayer("Here are the list of commands:");
        for (Command c : Chrome.INSTANCE.COMMAND_MANAGER.getCommands().values()) {
            PlayerUtils.tellPlayer(c.usage());
        }
        return true;
    }

    @Override
    public String usage() {
        return "USAGE: -help";
    }

}
