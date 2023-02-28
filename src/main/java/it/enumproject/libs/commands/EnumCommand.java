package it.enumproject.libs.commands;

import it.enumproject.libs.chat.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class EnumCommand implements CommandExecutor {

    protected final String command;
    protected final String permission;
    protected final boolean canConsoleUse;

    protected final JavaPlugin plugin;

    public EnumCommand(String command, String permission, boolean canConsoleUse, JavaPlugin plugin) {
        this.command = command;
        this.permission = permission;
        this.canConsoleUse = canConsoleUse;
        this.plugin = plugin;

        if(plugin != null) {
            plugin.getCommand(this.command).setExecutor(this);
        }
    }

    public abstract void execute(CommandSender sender, String[] args);

    public abstract String getPermissionMessage();
    public abstract String getNoConsoleMessage();

    protected void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(ChatUtils.color(message));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!canConsoleUse && ! (sender instanceof Player)) {
            sendMessage(sender, getNoConsoleMessage());
            return true;
        }

        if(permission != null && !sender.hasPermission(permission)) {
            sendMessage(sender, getPermissionMessage());
            return true;
        }

        execute(sender, args);
        return true;
    }

}