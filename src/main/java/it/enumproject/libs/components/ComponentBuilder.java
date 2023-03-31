package it.enumproject.libs.components;

import it.enumproject.libs.utils.ChatUtils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ComponentBuilder {

    private static TextComponent component;

    private static String name;

    public static ComponentBuilder create(String message) {
        ComponentBuilder.name = ChatUtils.color(message);
        component = new TextComponent(name);
        return new ComponentBuilder();
    }

    public ComponentBuilder clickAction(ClickEvent.Action action, String value) {
        component.setClickEvent(new ClickEvent(action, value));
        return this;
    }

    public ComponentBuilder hoverMessage(String hoverMessage) {
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponent[] { new TextComponent(ChatUtils.color(hoverMessage)) }));
        return this;
    }

    public void send(Player player) {
        player.spigot().sendMessage(component);
    }

}