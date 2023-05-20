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


    /**
     * Si va eventualmente a creare il file o eseguirci delle azioni sopra
     * @param instance Le instanze del plugin necessarie
     * @param fileName Il nome del file su cui si andranno ad eseguire le azioni
     */
    public FileService(EnumPlugin instance, String fileName) {
        this.file = new File(instance.getDataFolder() +  "/" + fileName);
        if(!this.file.exists()) {
            instance.saveResource(fileName, false);
        }
        this.fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    /**
     * Ricarica il file (+ save)
     */
    public FileService reload() {
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
        return this;
    }

    /**
     * Copia il file che si sta usando nel nuovo file che si va a specificare.
     * @param newFile Il file a cui si andrà a copiare tutto.
     */
    public FileService copy(File newFile) {
        FileUtil.copy(file, newFile);
        return this;
    }

    /**
     * Permette di copiare da un file il contenuto e portarlo al file corrente.
     * @param toCopy Il file da cui si andrà a copiare tutto.
     */
    public FileService inheritFrom(File toCopy) {
        FileUtil.copy(toCopy, file);
        reload();
        return this;
    }

    /**
     * Permette di salvare un file
     */
    public void save() {
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return La configurazione
     */
    public FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }

    /**
     * @return Il file a cui si eseguono le azioni
     */
    public File getFile() {
        return file;
    }

}