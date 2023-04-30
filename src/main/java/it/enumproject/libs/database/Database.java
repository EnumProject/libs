package it.enumproject.libs.database;

import java.sql.Connection;

public interface Database {
    /*
    Qui ci sarà l'url che andrà utilizzato per connettere il
    tutto nel database attraverso il metodo Database#connect
     */
    String getUrl();

    /*
    Questo metodo verrà richiamato nell'EnumPlugin per connettere
    il database all'inizializzazione del plugin.
     */
    void connect();

    /*
    Questo getter servirà solo per farsi ritornare la connection
    creata nel momento che l'interfaccia viene implementata.
     */
    Connection getConnection();
}