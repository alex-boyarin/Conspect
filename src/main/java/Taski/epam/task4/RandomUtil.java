package Taski.epam.task4;

import java.util.Random;

public class RandomUtil {
    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int getRandom(int value) {
        return RANDOM.nextInt(value);
    }
}
