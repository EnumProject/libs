package it.enumproject.libs.utils;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class ChatUtils {

    /**
     * Colora un messaggio attraverso il simbolo &
     * @param message Il messaggio che deve essere trasformato
     * @return Il messaggio formattato con i colori attraverso il simbolo &
     */
    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    /**
     * Colora una lista di stringhe
     * @param lines La lista di stringhe che vengono colorate
     * @return Ritorna una lista di stringhe colorata e formattate
     */
    public static List<String> color(List<String> lines) {
        return lines.stream().map(ChatUtils::color).collect(Collectors.toList());
    }

}