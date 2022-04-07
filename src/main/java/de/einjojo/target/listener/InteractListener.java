package de.einjojo.target.listener;

import de.einjojo.target.Target;
import de.einjojo.target.manager.GameManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class InteractListener implements Listener {


    private final Target plugin;
    private final GameManager gameManager;
    public InteractListener() {
        this.plugin = Target.getInstance();
        this.gameManager = this.plugin.getGameManager();
    }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        e.setCancelled(true);
    }
    @EventHandler
    public void onInventoryClick(InventoryMoveItemEvent e) {
        if(gameManager.getGameState() == GameManager.GAME_STATE.LOBBY) {
            e.setCancelled(true);
        }
    }



}
