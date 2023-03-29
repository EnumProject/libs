package it.enumproject.libs.commands;

import it.enumproject.libs.EnumPlugin;
import it.enumproject.libs.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class EnumCommand implements CommandExecutor {

    protected final String command;
    protected final String permission;
    protected final boolean onlyPlayers;

    protected final EnumPlugin plugin;

    public EnumCommand(String command, String permission, boolean onlyPlayers, EnumPlugin plugin) {
        this.command = command;
        this.permission = permission;
        this.onlyPlayers = onlyPlayers;
        this.plugin = plugin;

        if(plugin != null)
            plugin.getCommand(this.command).setExecutor(this);
    }

    public abstract void execute(CommandSender sender, String[] args);

    public abstract String getPermissionMessage();
    public abstract String getConsoleMessage();

    protected void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(ChatUtils.color(message));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(onlyPlayers && !(sender instanceof Player)) {
            sendMessage(sender, ChatUtils.color(getConsoleMessage()));
            return false;
        }

        if(permission != null && !sender.hasPermission(permission)) {
            sendMessage(sender, ChatUtils.color(getPermissionMessage()));
            return false;
        }

        execute(sender, args);
        return true;
    }

}