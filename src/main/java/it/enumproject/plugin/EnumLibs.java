package it.enumproject.plugin;

import it.enumproject.libs.EnumPlugin;
import it.enumproject.libs.logger.LogType;
import it.enumproject.libs.logger.Logger;
import it.enumproject.provider.EnumProvider;

public class EnumLibs extends EnumPlugin {

    private static EnumLibs instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        initialize();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        instance = null;
    }

    private void initialize() {
        instance = this;
        setProviderService(new EnumProvider());



        Logger.log(LogType.SUCCESS, "EnumLibs now is loaded.");
        Logger.log(LogType.SUCCESS, "Created by Enum Project (http://discord.enum-project.it)");
    }

    public static EnumLibs getInstance() {
        return instance;
    }

}