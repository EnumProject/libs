package it.enumproject.libs;

import it.enumproject.libs.provider.ProviderService;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class EnumPlugin extends JavaPlugin {

    private ProviderService providerService;

    public void setProviderService(ProviderService providerService) {
        this.providerService = providerService;
        providerService.init();
    }

}