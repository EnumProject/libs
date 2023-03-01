package it.enumproject.libs.listeners;

import it.enumproject.libs.chat.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class EnumListener implements Listener {

    protected final JavaPlugin plugin;

    public EnumListener(JavaPlugin plugin) {
        this.plugin = plugin;

        if(plugin != null)
            plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    protected void sendMessage(Player player, String message) {
        player.sendMessage(ChatUtils.color(message));
    }

}