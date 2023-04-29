package it.enumproject.libs;

import it.enumproject.libs.database.Database;
import it.enumproject.libs.services.ProviderService;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class EnumPlugin extends JavaPlugin {

    /**
     * Imposta il provider da cui va a prendere le informazioni.
     * @param providerService Il provider da cui va a prendere le informazioni
     */
    public void setProviderService(ProviderService providerService) {
        providerService.init();
    }

    /**
     * Va a connettere il database selezionato.
     * @param database Il database in cui prende tutte le informazioni e che viene registrato
     */
    public void connectDatabase(Database database) {
        database.connect();
    }

}