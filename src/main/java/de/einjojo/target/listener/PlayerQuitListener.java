package de.einjojo.target.listener;

import de.einjojo.target.Target;
import de.einjojo.target.manager.GameManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {


    private final Target plugin;
    private final GameManager gameManager;

    public PlayerQuitListener() {
        this.plugin = Target.getInstance();
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
        this.gameManager = this.plugin.getGameManager();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (gameManager.getPlayers().containsKey(e.getPlayer())) {
            e.setQuitMessage(plugin.getString("player_leave"));
        } else {
            e.setQuitMessage("");
        }
    }


}
