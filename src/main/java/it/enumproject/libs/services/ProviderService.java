package it.enumproject.libs.services;

public abstract class ProviderService {

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