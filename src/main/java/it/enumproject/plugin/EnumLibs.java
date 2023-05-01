package it.enumproject.plugin;

import it.enumproject.libs.EnumPlugin;
import it.enumproject.libs.logger.LogType;
import it.enumproject.libs.logger.Logger;
import it.enumproject.provider.EnumProvider;

public class EnumLibs extends EnumPlugin {

    public EnumLibs(EnumPlugin javaPlugin) {
        super(javaPlugin);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        initialize();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void initialize() {
        setProviderService(new EnumProvider());

        Logger.log(LogType.SUCCESS, "EnumLibs now is loaded.");
        Logger.log(LogType.SUCCESS, "Created by Enum Project (http://discord.enum-project.it)");
    }

}