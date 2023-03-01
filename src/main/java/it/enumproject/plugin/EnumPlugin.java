package it.enumproject.plugin;

import it.enumproject.libs.EnumLibs;
import it.enumproject.provider.LibsProvider;
import it.enumproject.provider.PluginProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class EnumPlugin extends JavaPlugin {

    private PluginProvider provider;
    private EnumLibs enumLibs;

    @Override
    public void onEnable() {
        // Plugin startup logic
        provider = new PluginProvider(this);
        enumLibs = new EnumLibs(new LibsProvider(), getDescription().getVersion());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}