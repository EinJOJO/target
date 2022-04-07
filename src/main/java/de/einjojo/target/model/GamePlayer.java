package de.einjojo.target.model;

import org.bukkit.entity.Player;

public class GamePlayer  {

    private final Player bukkitPlayer;

    private int kills;
    private int deaths;
    private int points;

    public GamePlayer(Player player) {
        this.bukkitPlayer = player;
        this.kills = 0;
        this.deaths = 0;
        this.points = 0;
    }

    public Player getBukkitPlayer() {
        return bukkitPlayer;
    }
}
