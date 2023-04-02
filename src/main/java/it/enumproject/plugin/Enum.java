package it.enumproject.plugin;

import it.enumproject.libs.EnumPlugin;
import it.enumproject.provider.EnumProvider;

public class Enum extends EnumPlugin {

    private static Enum instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        setProviderService(new EnumProvider());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
    }

    public static Enum getInstance() {
        return instance;
    }

}