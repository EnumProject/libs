package it.enumproject.plugin.handlers;

public enum Permission {

    ;

    private final String permission;

    Permission(String permission) {
        this.permission = "enumlibs." + permission;
    }

    public String getPermission() {
        return permission;
    }

}