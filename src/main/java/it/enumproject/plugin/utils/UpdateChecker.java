package it.enumproject.plugin.utils;

import it.enumproject.plugin.EnumLibs;

public class UpdateChecker {

    // TODO: Complete updatechecker

    public static boolean needsUpdate() {
        String url = "https://api.github.com/repos/EnumProject/libs/releases/latest";
        String pluginVersion = EnumLibs.getInstance().getDescription().getVersion();
        String latestVersion = "";

        return !pluginVersion.equals(latestVersion);
    }

}