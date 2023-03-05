package it.enumproject.libs;

import java.util.Random;

public class EnumLibs {

    private final String version;
    private static final Random random = new Random();

    public EnumLibs(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public static int chance() {
        return random.nextInt(100) + 10;
    }

}