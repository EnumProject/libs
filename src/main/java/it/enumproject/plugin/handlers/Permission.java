package it.enumproject.plugin.handlers;

import org.bukkit.permissions.Permissible;

public enum Permission {

    UPDATE_CHECKER("updates");

    private final String permission;

    Permission(String permission) {
        this.permission = "enumlibs." + permission;
    }

    /*
    Serve per fare un check e vedere se
    il player specificato ha il permesso specificato in precedenza
    attraverso il valore dell'enum.
     */
    public boolean has(Permissible permissible) {
        return permissible.hasPermission(permission);
    }

    /*
    Questo getter ritorna il permesso totale specificato
    attraverso il valore scelto quando viene richiamato l'enum.
     */
    public String getPermission() {
        return permission;
    }

}