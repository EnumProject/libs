package it.enumproject.libs.components;

import it.enumproject.libs.utils.ChatUtils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ComponentBuilder {

    private static TextComponent component;

    private static String name;

    /**
     * Permette di creare un messaggio che conterrà le varie azioni.
     * @param message Il messaggio che verrà inviato al giocatore.
     */
    public static ComponentBuilder create(String message) {
        ComponentBuilder.name = ChatUtils.color(message);
        component = new TextComponent(name);
        return new ComponentBuilder();
    }

    /**
     * Permette di creare l'azione che preferisci che verrà eseguita al click del messaggio.
     * @param action Il tipo di azione che dovrà eseguire al giocatore
     * @param value Il valore che varia in base al tipo di azione selezionato.
     */
    public ComponentBuilder clickAction(ClickEvent.Action action, String value) {
        component.setClickEvent(new ClickEvent(action, value));
        return this;
    }


    /**
     * Permette di inserire un messaggio che verrà mostrato quando si andrà con il mouse sopra il messaggio
     * @param hoverMessage Il messaggio che verrà mostrato. (ChatColor inclusa)
     */
    public ComponentBuilder hoverMessage(String hoverMessage) {
        component.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponent[] { new TextComponent(ChatUtils.color(hoverMessage)) }));
        return this;
    }

    /**
     * Invia il messaggio al giocatore specificato nel parametro.
     * @param player Il giocatore a cui verrà mandato il messaggio
     */
    public void send(Player player) {
        player.spigot().sendMessage(component);
    }

}