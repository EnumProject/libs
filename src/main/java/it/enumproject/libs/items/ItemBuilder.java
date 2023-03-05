package it.enumproject.libs.items;

import it.enumproject.libs.chat.ChatUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ItemBuilder implements Supplier<ItemStack> {

    private static ItemStack itemStack;

    public static ItemBuilder create(Material material) {
        itemStack = new ItemStack(material);
        return new ItemBuilder();
    }

    public ItemBuilder amount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder name(String name) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatUtils.color(name));

        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemBuilder lore(String... lore) {
        lore(Arrays.asList(lore));
        return this;
    }

    public ItemBuilder lore(List<String> lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(ChatUtils.color(lore));

        itemStack.setItemMeta(itemMeta);
        return this;
    }

    @Override
    public ItemStack get() {
        return itemStack;
    }
}