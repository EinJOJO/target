package de.einjojo.target.util;

import de.einjojo.target.Target;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;

public class Messages {

    private final Target plugin;
    private final Map<String, String> messages;
    public Messages() {
        this.plugin = Target.getInstance();
        this.messages = new HashMap<>();
    }

    public void loadMessagesFile() {
        File file = new File(plugin.getDataFolder(), "messages.yml");

        try {
            if (file.createNewFile()) {
                plugin.getLogger().info("Created messages.yml");
            }
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Could not create messages.yml");
            e.printStackTrace();
        }

        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        StringBuilder s = new StringBuilder();

        addLine(s, "# Target Plugin - Gamemode");
        addLine(s, "# Developed by EinJOJO (https://github.com/EinJOJO/)");
        addLine(s, "# 07.04.22");
        addLine(s, "# Developed for Florian / Kaktussucht.net");
        addLine(s, "# If you have issues with the message file changing characters, use -Dfile.encoding=UTF-8 in your JVM Start arguments");
        addLine(s,"");
        addLine(s, "");
        setMessage(s, config, "prefix", "&7[&eTarget&7] &8»");
        setMessage(s, config, "player_join", "%prefix% &e%player% hat das Spiel &abetreten");
        setMessage(s, config, "player_leave", "%prefix% &e%player% hat das Spiel &cverlassen");
        setMessage(s, config, "lobby_full", "&7Kaufe &6Premium &7lol. &cIch bin voll");
        addLine(s, "");
        addLine(s, "");


        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            writer.write(s.toString());
            writer.close();
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Could not write into messages.yml");
            e.printStackTrace();
        }

        Objects.requireNonNull(config.getConfigurationSection("")).getKeys(false).forEach(
                key -> messages.put(key, config.getString(key))
        );

    }
    private void addLine(StringBuilder builder, String value) {
        builder.append(value).append("\n");
    }

    private void setMessage(StringBuilder builder, FileConfiguration config, String key, String defaultValue) {
        String value = config.getString(key, defaultValue);
        builder.append(key).append(": \"").append(value).append("\"").append("\n");
    }

    private void setList(StringBuilder builder, FileConfiguration config, String key, List<String> defaultValues) {
        List<String> values = config.getStringList(key);
        if (values.isEmpty()) {
            values = defaultValues;
        }

        builder.append(key).append(":\n");
        for (String value : values) {
            builder.append(" - \"").append(value).append("\"").append("\n");
        }
    }

    public Map<String, String> getMessages() {
        return messages;
    }
}
