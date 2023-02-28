package it.enumproject.plugin.commands;

import it.enumproject.libs.commands.EnumCommand;
import it.enumproject.plugin.EnumPlugin;
import it.enumproject.plugin.handlers.Permission;
import org.bukkit.command.CommandSender;

public class MainCommand extends EnumCommand {

    private final EnumPlugin plugin;

    public MainCommand(EnumPlugin plugin) {
        super("enumlibs", Permission.COMMAND_MAIN.getPermission(), true, plugin);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sendMessage(sender, "&7Running &9Enum&bLibs &7version &f" + plugin.getDescription().getVersion());
        sendMessage(sender, "&7Created by &bEnum &9Project &7(Axiid)");
    }

    @Override
    public String getPermissionMessage() {
        return "&cYou don't have permissions.";
    }

    @Override
    public String getNoConsoleMessage() {
        return "&cYou can't execute this command by console.";
    }

}