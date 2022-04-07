package de.einjojo.target.util.enums;

import de.einjojo.target.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Items {
    Voter(ItemBuilder.create(Material.SUNFLOWER, "§a§lSchnellstart", "§7", "§7§oMöglich ab 3 Spielern oder mehr", "§7")),
    EXPLAINER(ItemBuilder.create(Material.BOOK, "§b§lErklärung", "§7", "§7§oLies mich, falls etwas", "§7§ounklar ist.", "§7")),
    LEAVE(ItemBuilder.create(Material.ENDER_EYE, "§c§lVerlassen", "§7", "§7Und tschüss", "§7"));

    private final ItemStack itemStack;
    Items(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }


}
