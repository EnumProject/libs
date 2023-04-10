package it.enumproject.libs.provider;

public abstract class ProviderService {

    public ProviderService() {
        init();
    }

    public void init() {
        getCommands();
        getListeners();
        getTasks();
    }

    public abstract void getCommands();
    public abstract void getListeners();
    public abstract void getTasks();
    public abstract void getHooks();

}