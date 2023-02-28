package it.enumproject.libs;

import it.enumproject.provider.LibsProvider;

public class EnumLibs {

    private final LibsProvider provider;

    public EnumLibs(LibsProvider provider) {
        this.provider = provider;
    }

    public LibsProvider getProvider() {
        return provider;
    }

}