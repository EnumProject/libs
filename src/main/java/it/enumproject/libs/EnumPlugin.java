package it.enumproject.libs;

import it.enumproject.libs.files.FileUtils;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class EnumPlugin extends JavaPlugin {

    private EnumPlugin instance;
    private FileUtils fileUtils;

    @Override
    public void onEnable() {
        instance = this;
        fileUtils = new FileUtils(instance);
    }

    @Override
    public void onDisable() {
        fileUtils = null;
    }

    public FileUtils getFileUtils() {
        return fileUtils;
    }

}