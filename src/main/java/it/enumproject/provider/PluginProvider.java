package it.enumproject.provider;

import it.enumproject.plugin.EnumPlugin;
import it.enumproject.plugin.commands.MainCommand;

public class PluginProvider {

    private final EnumPlugin plugin;

    public PluginProvider(EnumPlugin plugin) {
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