package it.enumproject.libs.files;

import com.google.common.io.ByteStreams;
import it.enumproject.libs.EnumPlugin;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class FileUtils {

    private static EnumPlugin instance;

    public FileUtils(EnumPlugin instance) {
        FileUtils.instance = instance;
    }

    public static void create(String fileName) {
        File file = get(fileName);

        if (file.exists()) return;

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        copy(fileName);
    }

    public static void copy(String fileName) {
        File file = get(fileName);

        try (InputStream is = instance.getResource(fileName + ".yml");
             OutputStream os = Files.newOutputStream(file.toPath())) {
            ByteStreams.copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load(String fileName) {
        FileConfiguration configuration = new YamlConfiguration();

        try {
            configuration.load(get(fileName));
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }

    public static File get(String fileName) {
        return new File(instance.getDataFolder(), fileName + ".yml");
    }

}