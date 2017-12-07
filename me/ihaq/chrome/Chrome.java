package me.ihaq.chrome;

import me.ihaq.chrome.file.CustomFileManager;
import org.lwjgl.opengl.Display;

import me.ihaq.chrome.command.CommandManager;
import me.ihaq.chrome.event.EventManager;
import me.ihaq.chrome.module.ModuleManager;
import me.ihaq.chrome.setting.SettingManager;

import java.io.File;
import java.io.FileReader;

public enum Chrome {

    INSTANCE;

    /**
     * The variables that hold the Client Name and the Client Version.
     **/
    public final String NAME = "Chrome";
    public final double VERSION = 1.0;

    /**
     * Declaring all the objects, required for the client to function.
     **/
    public EventManager EVENT_MANAGER;
    public ModuleManager MODULE_MANAGER;
    public SettingManager SETTING_MANAGER;
    public CommandManager COMMAND_MANAGER;
    public CustomFileManager FILE_MANAGER;

    /**
     * This method is called after minecraft is done loading. This method
     * instantiates all the objects required for the client to function.
     **/
    public void onEnable() {

        /** Instantiating all the objects. **/
        EVENT_MANAGER = new EventManager();
        MODULE_MANAGER = new ModuleManager();
        SETTING_MANAGER = new SettingManager();
        COMMAND_MANAGER = new CommandManager();
        FILE_MANAGER = new CustomFileManager();

        /** Sets the title of the window. (Seen on top left of screen). **/
        Display.setTitle(NAME + " | " + VERSION);

        /** Loading **/
        MODULE_MANAGER.loadMods();
        COMMAND_MANAGER.loadCommands();
        FILE_MANAGER.loadFiles();
    }

    /**
     * This method is called when minecraft is shutting down. Usually the only thing
     * that goes here is saving the files.
     **/
    public void onDisable() {
        FILE_MANAGER.saveFiles();
    }


}
