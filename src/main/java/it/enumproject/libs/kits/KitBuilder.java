package it.enumproject.libs.kits;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;

public class KitBuilder {

    private static Player player;

    private static final List<ItemStack> kit = new ArrayList<>();

    private ItemStack helmet;
    private ItemStack chestPlate;
    private ItemStack leggings;
    private ItemStack boots;

    public static KitBuilder create(Player player) {
        KitBuilder.player = player;
        return new KitBuilder();
    }

    public KitBuilder add(ItemStack itemStack) {
        kit.add(itemStack);
        return this;
    }

    public KitBuilder setArmorContents(ItemStack helmet, ItemStack chestPlate, ItemStack leggings, ItemStack boots) {
        this.helmet = helmet;
        this.chestPlate = chestPlate;
        this.leggings = leggings;
        this.boots = boots;

        return this;
    }

    public void give(String permission) {
        if(!player.hasPermission(permission)) return;
        PlayerInventory inventory = player.getInventory();

        inventory.setHelmet(helmet);
        inventory.setChestplate(chestPlate);
        inventory.setLeggings(leggings);
        inventory.setBoots(boots);

        kit.forEach(inventory::addItem);
        kit.clear();
    }

}
