package it.enumproject.libs.listeners;

import it.enumproject.libs.EnumPlugin;
import it.enumproject.libs.utils.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

public abstract class EnumListener implements Listener {

    protected final EnumPlugin plugin;

    public EnumListener(EnumPlugin plugin) {
        this.plugin = plugin;

        if(plugin != null)
            plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    /**
     * Permette di inviare un messaggio a un giocatore con chat color inclusa
     * @param sender - Il giocatore a cui viene inviato il messaggio
     * @param message - Il messaggio che verrà inviato al giocatore speicficato
     */
    protected void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(ChatUtils.color(message));
    }

}