package de.einjojo.target.listener;

import de.einjojo.target.Target;
import de.einjojo.target.manager.GameManager;

import de.einjojo.target.util.Placeholder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {


    private final GameManager gameManager;
    private final Target plugin;
    public PlayerJoinListener() {
        this.plugin = Target.getInstance();
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
        this.gameManager = this.plugin.getGameManager();

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (gameManager.getGameState() != GameManager.GAME_STATE.LOBBY) {
            e.getPlayer().kickPlayer("§cDas Spiel läuft bereits");
            return;
        }
        e.setJoinMessage(Placeholder.replace(Placeholder.PLAYER, plugin.getString("player_join"), e.getPlayer().getName()));




    }
}
