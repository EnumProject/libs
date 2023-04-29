package it.enumproject.libs.items;

import it.enumproject.libs.utils.ChatUtils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ItemBuilder implements Supplier<ItemStack> {

    private static ItemStack itemStack;
    private static ItemMeta itemMeta;

    // Serve per ritornare un item vuoto.
    public static ItemStack EMPTY_STACK = new ItemStack(Material.AIR);

    /**
     *
     * @param material Il materiale che verrà utilizzato quando si andrà a creare l'item.
     */
    public static ItemBuilder create(Material material) {
        itemStack = new ItemStack(material);
        itemMeta = itemStack.getItemMeta();
        return new ItemBuilder();
    }

    /**
     *
     * @param name Il nome che assumerà l'item. (ChatColor inclusa)
     */
    public ItemBuilder name(String name) {
        itemMeta.setDisplayName(ChatUtils.color(name));
        return this;
    }

    /**
     *
     * @param amount Il numero degli item che verranno mostrati e/o givvati.
     */
    public ItemBuilder amount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    /**
     *
     * @param lines Le linee che verranno utilizzate per impostare la lore.
     */
    public ItemBuilder lore(String... lines) {
        itemMeta.setLore(ChatUtils.color(Arrays.asList(lines)));
        return this;
    }

    /**
     *
     * @param lines Le linee che verranno utilizzate per impostare la lore.
     */
    public ItemBuilder lore(List<String> lines) {
        itemMeta.setLore(ChatUtils.color(lines));
        return this;
    }

    /**
     *
     * @param color Il colore che verrà dato all'armatura in leather.
     */
    public ItemBuilder color(Color color) {
        LeatherArmorMeta armorMeta = (LeatherArmorMeta) itemMeta;
        armorMeta.setColor(color);
        return this;
    }

    /**
     *
     * @param section La sezione da cui il metodo riprenderà tutte le informazioni per creare l'item.
     */
    public ItemBuilder inherit(ConfigurationSection section) {
        amount(section.getInt("amount"));
        name(section.getString("name"));
        lore(section.getStringList("lore"));
        return this;
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