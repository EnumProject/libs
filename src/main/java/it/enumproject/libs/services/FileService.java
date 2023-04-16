package it.enumproject.libs.services;

import it.enumproject.libs.EnumPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.util.FileUtil;

import java.io.File;
import java.io.IOException;

public class FileService {

    private final File file;
    private FileConfiguration fileConfiguration;


    public FileService(EnumPlugin instance, String fileName) {
        this.file = new File(instance.getDataFolder() +  "/" + fileName);
        if(!this.file.exists()) {
            instance.saveResource(fileName, false);
        }
        this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public FileService reload() {
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
        return this;
    }

    public FileService copy(File newFile) {
        FileUtil.copy(file, newFile);
        return this;
    }

    public FileService inheritFrom(File toCopy) {
        FileUtil.copy(toCopy, file);
        reload();
        return this;
    }

    public void save() {
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}