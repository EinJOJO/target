package de.einjojo.target.manager;

import de.einjojo.target.model.GamePlayer;
import org.bukkit.entity.Player;

import java.util.*;

public class GameManager {

    private GAME_STATE gameState;
    private Map<Player, GamePlayer> players;

    public GameManager() {
        gameState = GAME_STATE.LOBBY;
        players = new HashMap<>();
    }


    public Map<Player, GamePlayer> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.put(player, new GamePlayer(player));
    }
    public void removePlayer(Player player) {
        players.remove(player);
    }


    public GAME_STATE getGameState() {
        return gameState;
    }
    public void setGameState(GAME_STATE gameState) {
        this.gameState = gameState;
    }

    public enum GAME_STATE {
        LOBBY,
        RUNNING,
        ENDING,
    }

}

