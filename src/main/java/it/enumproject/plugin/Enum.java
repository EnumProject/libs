package it.enumproject.plugin;

import it.enumproject.provider.EnumProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Enum extends JavaPlugin {

    private static Enum instance;
    private EnumProvider provider;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        provider = new EnumProvider();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
        provider = null;
    }

    public static Enum getInstance() {
        return instance;
    }

    public EnumProvider getProvider() {
        return provider;
    }

}