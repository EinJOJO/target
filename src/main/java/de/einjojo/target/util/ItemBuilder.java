package de.einjojo.target.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    public static ItemStack create(Material material) {
        return new ItemStack(material);
    }

    public static ItemStack create(Material material, String name) {
        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();
        assert meta != null;
        meta.setDisplayName(name);
        stack.setItemMeta(meta);
        return stack;
    }

    public static ItemStack create(Material material, String name, String ...lore) {
        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();
        assert meta != null;
        List<String> _lore = Arrays.asList(lore);
        meta.setLore(_lore);
        meta.setDisplayName(name);
        stack.setItemMeta(meta);
        return stack;
    }



}
