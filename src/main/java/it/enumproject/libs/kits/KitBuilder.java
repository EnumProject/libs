package it.enumproject.libs.kits;

import it.enumproject.libs.player.EnumPlayer;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class KitBuilder {

    private static EnumPlayer player;

    private static final List<ItemStack> kit = new ArrayList<>();

    public static KitBuilder create(EnumPlayer player) {
        KitBuilder.player = player;
        return new KitBuilder();
    }

    public KitBuilder add(ItemStack itemStack) {
        kit.add(itemStack);
        return this;
    }

    public void give(String permission) {
        if(!player.hasPermission(permission)) return;
        kit.forEach(itemStack -> player.getInventory().addItem(itemStack));
        kit.clear();
    }

}
