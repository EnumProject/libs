package it.enumproject.libs.items;

import it.enumproject.libs.utils.ChatUtils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;
import java.util.function.Supplier;

public class ItemBuilder implements Supplier<ItemStack> {

    private static ItemStack itemStack;
    private static ItemMeta itemMeta;

    public static ItemStack EMPTY_STACK = new ItemStack(Material.AIR);

    public static ItemBuilder create(Material material) {
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
        return new ItemBuilder();
    }

    public ItemBuilder name(String name) {
        itemMeta.setDisplayName(ChatUtils.color(name));
        return this;
    }

    public ItemBuilder amount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder lore(String... lines) {
        itemMeta.setLore(ChatUtils.color(Arrays.asList(lines)));
        return this;
    }

    public ItemBuilder color(Color color) {
        LeatherArmorMeta armorMeta = (LeatherArmorMeta) itemMeta;
        armorMeta.setColor(color);
        return this;
    }

    @Override
    public ItemStack get() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}