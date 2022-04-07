package de.einjojo.target.listener;

import de.einjojo.target.Target;
import de.einjojo.target.manager.GameManager;

import de.einjojo.target.util.enums.Items;
import de.einjojo.target.util.enums.Placeholder;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
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
            e.setJoinMessage("");
            e.getPlayer().setGameMode(GameMode.SPECTATOR); //TODO: Spectator System
            return;
        }
        final Player player = e.getPlayer();
        e.setJoinMessage(Placeholder.replace(Placeholder.PLAYER, plugin.getString("player_join"), player.getName()));
        gameManager.addPlayer(player);
    }


    private void giveLobbyItems (Player player) {
        player.getInventory().clear();
        player.getInventory().setItem(1, Items.Voter.getItemStack());
        player.getInventory().setItem(4, Items.EXPLAINER.getItemStack());
        player.getInventory().setItem(7, Items.LEAVE.getItemStack());
    }
}
