package it.enumproject.libs.utils;

import java.util.Random;

public class Utils {

    private static final Random random = new Random();

    public static int chance() {
        return random.nextInt(100) + 1;
    }

}