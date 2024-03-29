package it.enumproject.provider;

import it.enumproject.libs.EnumPlugin;
import it.enumproject.libs.services.ProviderService;
import it.enumproject.plugin.EnumLibs;
import it.enumproject.plugin.command.MainCommand;

public class EnumProvider extends ProviderService {

    private final EnumPlugin plugin = EnumLibs.getJavaPlugin();

    @Override
    public void getCommands() {
        new MainCommand(plugin);
    }

    @Override
    public void getListeners() {

    }

    @Override
    public void getTasks() {

    }

    @Override
    public void getHooks() {

    }

}