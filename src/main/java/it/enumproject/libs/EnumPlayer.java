package it.enumproject.libs;

import org.bukkit.entity.Player;

import java.util.Optional;

/**
 * Istanza del {@link Player} usata da enum libs
 * */
public interface EnumPlayer {
    /**
     * @return l'istanza del {@link Player} di bukkit, l'optional sarà vuoto se il giocatore non è online
     * */
    Optional<Player> getHandle();
    /**
     * da capire cosa voglia fare axiid
     * */
    void sendToServer(String serverName);
    /**
     * Invia un messaggio a un giocatore, supporta i codici colore
     * @param message è il messaggio da inviare
     * */
    void sendMessage(String message);
}