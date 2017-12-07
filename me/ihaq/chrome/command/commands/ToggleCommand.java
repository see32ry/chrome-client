package me.ihaq.chrome.command.commands;

import me.ihaq.chrome.Chrome;
import me.ihaq.chrome.command.Command;
import me.ihaq.chrome.module.Module;
import me.ihaq.chrome.utils.PlayerUtils;

public class ToggleCommand implements Command {

    @Override
    public boolean run(String[] args) {

        if (args.length == 2) {

            Module module = Chrome.INSTANCE.MODULE_MANAGER.getModule(args[1]);

            if (module == null) {
                PlayerUtils.tellPlayer("The module with the name " + args[1] + " does not exist.");
                return true;
            }

            module.toggle();

            return true;
        }


        return false;
    }

    @Override
    public String usage() {
        return "USAGE: -toggle [module]";
    }
}
