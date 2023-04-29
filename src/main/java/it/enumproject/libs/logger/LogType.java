package it.enumproject.libs.logger;

import it.enumproject.libs.utils.ChatUtils;

public enum LogType {

    WARN("&e[WARN]"),
    ERROR("&c[ERROR]"),
    INFO("&3[INFO]"),
    SUCCESS("&a[SUCCCESS]");

    private final String prefix;

    LogType(String prefix) {
        this.prefix = prefix;
    }

    /*
    Ritorna il determinato prefisso di uno
    specifico tipo del log
     */
    public String getPrefix() {
        return ChatUtils.color(prefix);
    }

}