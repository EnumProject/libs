package it.enumproject.libs.scoreboard;

import it.enumproject.libs.utils.ChatUtils;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class ScoreBuilder {

    protected void scoreboard(Player player, String title) {
        ScoreHandler scoreHandler = ScoreHandler.createScore(player);
        scoreHandler.setTitle(title);
    }

    protected void update(Player player, List<String> scoreboardLines) {
        ScoreHandler scoreHandler = ScoreHandler.getByPlayer(player);

        if(ScoreHandler.hasScore(player)) {
            scoreHandler.setSlotsFromList(ChatUtils.color(scoreboardLines));
        }
    }

}