package de.einjojo.target.model;

import org.bukkit.entity.Player;

public class GamePlayer  {

    Player bukkitPlayer;

    int kills;
    int deaths;
    int points;

    public GamePlayer(Player player) {
        this.bukkitPlayer = player;
        this.kills = 0;
        this.deaths = 0;
        this.points = 0;
    }
}
