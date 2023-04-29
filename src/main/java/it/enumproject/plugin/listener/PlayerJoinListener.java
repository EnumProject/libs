package it.enumproject.plugin.listener;

import it.enumproject.libs.EnumPlugin;
import it.enumproject.libs.components.ComponentBuilder;
import it.enumproject.libs.listeners.EnumListener;
import it.enumproject.plugin.handlers.Permission;
import it.enumproject.plugin.utils.UpdateChecker;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener extends EnumListener {

    public PlayerJoinListener(EnumPlugin plugin) {
        super(plugin);

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(Permission.UPDATE_CHECKER.has(player)) return;

        if(!UpdateChecker.needsUpdate()) return;

        sendMessage(player, "&eEnumLibs need updates!");
        ComponentBuilder.create("&eDownload it from our discord by clicking here.")
                .hoverMessage("&7Click here!")
                .clickAction(ClickEvent.Action.OPEN_URL, "http://discord.enum-project.it")
                .send(player);

    }

}