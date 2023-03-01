package it.enumproject.libs;

import it.enumproject.provider.LibsProvider;

public class EnumLibs {

    private final LibsProvider provider;
    private final String version;

    public EnumLibs(LibsProvider provider, String version) {
        this.provider = provider;
        this.version = version;
    }

    public LibsProvider getProvider() {
        return provider;
    }

    public String getVersion() {
        return version;
    }

}