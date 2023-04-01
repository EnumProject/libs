package it.enumproject.libs.provider;

public abstract class ProviderService {

    public ProviderService() {
        init();
    }

    private void init() {
        getCommands();
        getListeners();
    }

    public abstract void getCommands();

    public abstract void getListeners();

}