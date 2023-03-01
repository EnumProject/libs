package it.enumproject.libs.inventory;

import it.enumproject.libs.chat.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class InventoryBuilder implements Supplier<Inventory>, Listener {

    private static Inventory inventory;
    private static boolean closeable;

    private String title;

    private int row, column;

    private int slotId;
    private Consumer<InventoryClickEvent> consumer;

    public static InventoryBuilder create(JavaPlugin plugin, boolean closeable) {
        InventoryBuilder.closeable = closeable;
        if(!closeable) {
            plugin.getServer().getPluginManager().registerEvents(new InventoryBuilder(), plugin);
        }
        return new InventoryBuilder();
    }

    public InventoryBuilder title(String title) {
        this.title = ChatUtils.color(title);
        return this;
    }

    public InventoryBuilder size(int row, int column) {
        this.row = row;
        this.column = column;
        return this;
    }

    public InventoryBuilder addAction(int slotId, Consumer<InventoryClickEvent> consumer) {
        this.slotId = slotId;
        this.consumer = consumer;
        return this;
    }

    @Override
    public Inventory get() {
        inventory = Bukkit.createInventory(null, row * column, title);
        return inventory;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if(!closeable) {
            event.getPlayer().openInventory(inventory);
        }
    }

    public void onClick(InventoryClickEvent event) {
        if(!event.getView().getTitle().equals(inventory.getTitle())) return;
        if(event.getSlot() != slotId) return;
        consumer.accept(event);
    }

}