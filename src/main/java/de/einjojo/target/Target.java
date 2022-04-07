package de.einjojo.target;

import de.einjojo.target.listener.InteractListener;
import de.einjojo.target.listener.PlayerJoinListener;
import de.einjojo.target.listener.PlayerQuitListener;
import de.einjojo.target.manager.GameManager;
import de.einjojo.target.util.Messages;
import de.einjojo.target.util.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.w3c.dom.css.RGBColor;

public final class Target extends JavaPlugin {

    public final String PREFIX = "§4[Target] ";
    private static Target instance;
    private GameManager gameManager;
    private Messages messages;



    @Override
    public void onLoad() {
        instance = this;
        messages = new Messages();
        if(getDataFolder().mkdir()) {
            getLogger().info("Created the plugin folder");
        }
        this.messages = new Messages();
        messages.loadMessagesFile();
    }

    @Override
    public void onEnable() {
        gameManager = new GameManager();
        registerListeners();
    }

    @Override
    public void onDisable() {

    }


    private void registerListeners() {
        new InteractListener();
        new PlayerQuitListener();
        new PlayerJoinListener();
    }

    private String getPrefixString() {

        try {
            String prefix = messages.getMessages().get("prefix");
            return (prefix != null ? ChatColor.translateAlternateColorCodes('&', prefix) : PREFIX);
        } catch (NullPointerException e) {
            Bukkit.getConsoleSender().sendMessage(PREFIX + "No prefix found! Using default prefix.");
            return PREFIX;
        }
    }

    public String getString(String key) {
        try {
            String message = messages.getMessages().get(key);
            message = Placeholder.replace(Placeholder.PREFIX, message, getPrefixString());
            return ChatColor.translateAlternateColorCodes('&', message);
        } catch (NullPointerException e) {
            Bukkit.getConsoleSender().sendMessage(PREFIX + "Could not find message with key: " + key);
            return "undefined";
        }
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    public static Target getInstance() {
        return instance;
    }
}
