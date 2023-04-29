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

    /**
     * Permette di creare un comando con più facilità :)
     * @param command Il comando che un giocatore dovrà eseguire
     * @param permission Il permesso che un giocatore deve avere per eseguire il comando
     * @param onlyPlayers Permette di scegliere se il comando è eseguibile solo da giocatore o no
     * @param plugin Passa il parametro del plugin per avere tutte le informazioni su di esso
     */
    public EnumCommand(String command, String permission, boolean onlyPlayers, EnumPlugin plugin) {
        this.command = command;
        this.permission = permission;
        this.onlyPlayers = onlyPlayers;
        this.plugin = plugin;

        if(plugin != null)
            plugin.getCommand(this.command).setExecutor(this);
    }

    /**
     * Questo metodo conterrà il contenuto del comando specificato.
     * @param sender Colui che esegue il comando
     * @param args Gli argomenti del comando.
     */
    public abstract void execute(CommandSender sender, String[] args);

    /**
     * @return Il permesso che verrà mostrato quando un giocatore non ha il permesso specificato nel costruttore.
     */
    public abstract String getPermissionMessage();

    /**
     * @return Il messaggio che verrà mostrato quando una persona non potrà eseguire un determinato comando dalla console.
     */
    public abstract String getConsoleMessage();

    /**
     * Permette di inviare un messaggio a un giocatore con chat color inclusa
     * @param sender Il giocatore a cui viene inviato il messaggio
     * @param message Il messaggio che verrà inviato al giocatore speicficato
     */
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