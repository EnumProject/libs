package it.enumproject.libs.services;

public abstract class ProviderService {

    // Inizializza tutto il contenuto dei vari metodi
    public void init() {
        getCommands();
        getListeners();
        getTasks();
    }

    // Registra tutti i comandi qui
    public abstract void getCommands();

    // Registra tutti i listeners qui
    public abstract void getListeners();

    // Registra tutte le tasks qui
    public abstract void getTasks();

    // Registra tutti gli hoooks qui
    public abstract void getHooks();

}