package it.enumproject.libs.logger;

import it.enumproject.libs.utils.ChatUtils;
import org.bukkit.Bukkit;

public class Logger {

    /**
     * Manda un determinato log in console
     * @param type Il tipo di log che viene inviato
     * @param message Il messaggio che viene mandato
     */
    public static void log(LogType type, String message) {
        Bukkit.getLogger().info(ChatUtils.color(type.getPrefix() + " " + message));
    }

    /**
     * Permette di ritornare il prefisso di un determinato tipo di log.
     * @param type Il tipo di log di cui si vuole il prefisso
     * @return Il prefisso del tipo di log
     */
    public static String getLogPrefix(LogType type) {
        return type.getPrefix();
    }

}