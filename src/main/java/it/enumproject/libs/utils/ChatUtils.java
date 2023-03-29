package it.enumproject.libs.utils;

import org.bukkit.ChatColor;

import java.util.List;

public class ChatUtils {

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> color(List<String> lines) {
        for(String line : lines) {
            color(line);
        }
        return lines;
    }

}