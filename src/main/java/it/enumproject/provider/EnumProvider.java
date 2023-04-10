package it.enumproject.provider;

import it.enumproject.libs.provider.ProviderService;
import it.enumproject.plugin.Enum;
import it.enumproject.plugin.command.MainCommand;

public class EnumProvider extends ProviderService {

    private final Enum plugin = Enum.getInstance();

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