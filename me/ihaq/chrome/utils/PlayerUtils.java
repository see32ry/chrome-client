package me.ihaq.chrome.utils;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.ihaq.chrome.Chrome;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class PlayerUtils {

    /**
     * This method can be used to send your player a message. This message can only
     * be seen by you, no one else.
     **/
    public static void tellPlayer(String text) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(
                ChatFormatting.WHITE + "[" + ChatFormatting.RED + Chrome.INSTANCE.NAME + ChatFormatting.WHITE + "] " + text));
    }
}
