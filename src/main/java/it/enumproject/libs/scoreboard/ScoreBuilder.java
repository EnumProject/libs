package it.enumproject.libs.scoreboard;

import it.enumproject.libs.utils.ChatUtils;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class ScoreBuilder {

    /**
     * Crea e imposta il titolo ad una scoreboard.
     * @param player Il giocatore a cui viene impostata
     * @param title Il titolo della scorebaord
     */
    protected void scoreboard(Player player, String title) {
        ScoreHandler scoreHandler = ScoreHandler.createScore(player);
        scoreHandler.setTitle(title);
    }

    /**
     * Imposta la vera e propria scoreboard del giocatore.
     * @param player Il giocatore a cui viene impostata la scoreboard
     * @param scoreboardLines La lista di linee che imposta la scoreboard vera e propria
     */
    protected void update(Player player, List<String> scoreboardLines) {
        ScoreHandler scoreHandler = ScoreHandler.getByPlayer(player);

        if(ScoreHandler.hasScore(player)) {
            scoreHandler.setSlotsFromList(ChatUtils.color(scoreboardLines));
        }
    }

}