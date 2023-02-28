package it.enumproject.libs.chat;

import org.bukkit.ChatColor;

import java.util.List;

public class ChatUtils {

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> color(List<String> messages) {
        for(String message : messages) {
            ChatColor.translateAlternateColorCodes('&', message);
        }
        return messages;
    }

}