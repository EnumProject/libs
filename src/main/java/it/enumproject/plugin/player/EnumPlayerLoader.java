package it.enumproject.plugin.player;

import it.enumproject.libs.EnumPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Optional;

public class EnumPlayerLoader implements EnumPlayer {
    private final String playerName;

    public EnumPlayerLoader(final String playerName) {
        this.playerName = playerName;
    }

    @Override
    public Optional<Player> getHandle() {
        return Optional.ofNullable(Bukkit.getPlayer(playerName));
    }

    @Override
    public void sendToServer(String serverName) {

    }

    @Override
    public void sendMessage(String message) {
        final Player player = Bukkit.getPlayer(playerName);
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
