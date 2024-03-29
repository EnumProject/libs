package it.enumproject.libs.items;

import it.enumproject.libs.logger.LogType;
import it.enumproject.libs.logger.Logger;
import it.enumproject.libs.utils.ChatUtils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ItemBuilder implements Supplier<ItemStack> {
    private static ItemStack itemStack;
    private static ItemMeta itemMeta;

    // Serve per ritornare un item vuoto.
    public static ItemStack EMPTY_STACK = new ItemStack(Material.AIR);

    /**
     * Permette di creare un nuovo item.
     * @param material Il materiale che verrà utilizzato quando si andrà a creare l'item.
     */
    public static ItemBuilder create(Material material) {
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
        return new ItemBuilder();
    }

    /**
     * Permette di assegnare un nome all'item.
     * @param name Il nome che assumerà l'item. (ChatColor inclusa)
     */
    public ItemBuilder name(String name) {
        itemMeta.setDisplayName(ChatUtils.color(name));
        return this;
    }

    /**
     * Imposta il numero degli item che verranno dati.
     * @param amount Il numero degli item che verranno mostrati e/o givvati.
     */
    public ItemBuilder amount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    /**
     * Permette di impostare una lore.
     * @param lines Le linee che verranno utilizzate per impostare la lore.
     */
    public ItemBuilder lore(String... lines) {
        itemMeta.setLore(ChatUtils.color(Arrays.asList(lines)));
        return this;
    }

    /**
     * Permette di impostare una lore.
     * @param lines Le linee che verranno utilizzate per impostare la lore.
     */
    public ItemBuilder lore(List<String> lines) {
        itemMeta.setLore(ChatUtils.color(lines));
        return this;
    }

    /**
     * Permette di assegnare un colore ad un armatura in leather.
     * @param color Il colore che verrà dato all'armatura in leather.
     */
    public ItemBuilder color(Color color) {
        LeatherArmorMeta armorMeta = (LeatherArmorMeta) itemMeta;
        armorMeta.setColor(color);
        return this;
    }

    /**
     * Permette di prendere da una sezione di una configurazione l'item.
     * @param section La sezione da cui il metodo riprenderà tutte le informazioni per creare l'item.
     */
    public ItemBuilder inherit(ConfigurationSection section) {
        amount(section.getInt("amount"));
        name(section.getString("name"));
        lore(section.getStringList("lore"));
        return this;
    }

    /**
     * Aggiunge la possiblità d'impostare un custom model data per le texture pack
     * ATTENZIONE: Questo metodo non è supportato da versione inferiori alla 1.18
     * @param data è l'id del modello target nella texture pack
     * */
    public ItemBuilder customModelData(int data) {
        try {
            itemMeta.getClass().getMethod("setCustomModelData", Integer.class).invoke(data, data);
            return this;
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            Logger.log(LogType.ERROR, "Errore nel processo di settaggio del custom model data per un item: " + itemStack.toString());
            return this;
        }
    }

    /**
     *
     * @return L'item con tutti i valori specificati in precedenza
     */
    @Override
    public ItemStack get() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}