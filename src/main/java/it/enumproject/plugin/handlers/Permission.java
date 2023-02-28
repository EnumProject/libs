package it.enumproject.plugin.handlers;

import org.bukkit.permissions.Permissible;

public enum Permission {

    COMMAND_MAIN("command.main");

    private final String permission;

    Permission(String permission) {
        this.permission = "enumlibs." + permission;
    }

    public String getPermission() {
        return permission;
    }

    public boolean has(Permissible permissible) {
        return permissible.hasPermission(permission);
    }

}