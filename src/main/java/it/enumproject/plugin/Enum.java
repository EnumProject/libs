package it.enumproject.plugin;

import it.enumproject.libs.EnumPlugin;
import it.enumproject.provider.EnumProvider;

public class Enum extends EnumPlugin {

    private static Enum instance;
    private EnumProvider provider;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        provider = new EnumProvider(this);
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