package it.enumproject.plugin;

import it.enumproject.provider.PluginProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class EnumPlugin extends JavaPlugin {

    private PluginProvider provider;

    @Override
    public void onEnable() {
        // Plugin startup logic
        provider = new PluginProvider(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}