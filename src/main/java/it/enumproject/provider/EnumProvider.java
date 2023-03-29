package it.enumproject.provider;

import it.enumproject.plugin.Enum;
import it.enumproject.plugin.command.MainCommand;

public class EnumProvider {

    private final Enum plugin;

    public EnumProvider(Enum plugin) {
        this.plugin = plugin;
        init();
    }

    private void init() {
        getCommands();
        getListeners();
    }

    private void getCommands() {
        new MainCommand(plugin);
    }

    private void getListeners() {

    }

}