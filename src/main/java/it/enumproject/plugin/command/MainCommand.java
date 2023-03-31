package it.enumproject.plugin.command;

import it.enumproject.libs.commands.EnumCommand;
import it.enumproject.libs.components.ComponentBuilder;
import it.enumproject.plugin.Enum;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand extends EnumCommand {

    private final Enum plugin;

    public MainCommand(Enum plugin) {
        super("enumlibs", "", false, plugin);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sendMessage(sender, "&7Running &bEnumLibs &7version &3" + plugin.getDescription().getVersion());
        sendMessage(sender, "&7Created by &aAxiid");
    }

    @Override
    public String getPermissionMessage() {
        return "&cNessun permesso.";
    }

    @Override
    public String getConsoleMessage() {
        return "&cNon puoi eseguire questo comando dalla console.";
    }

}