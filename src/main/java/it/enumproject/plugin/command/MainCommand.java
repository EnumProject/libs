package it.enumproject.plugin.command;

import it.enumproject.libs.commands.EnumCommand;
import it.enumproject.libs.components.ComponentBuilder;
import it.enumproject.plugin.EnumLibs;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand extends EnumCommand {

    private final EnumLibs plugin;

    public MainCommand(EnumLibs plugin) {
        super("enumlibs", "", false, plugin);
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sendMessage(sender, "&7Running &bEnumLibs &7version &3" + plugin.getDescription().getVersion());
        sendMessage(sender, "&7Created by &3Enum Project");

        if(sender instanceof Player) {
            sendMessage(sender, "");
            ComponentBuilder.create("&3Clicca qui per entrare nel discord!")
                    .clickAction(ClickEvent.Action.OPEN_URL, "http://discord.enum-project.it")
                    .hoverMessage("&7Clicca per aprire!")
                    .send((Player) sender);
        }

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