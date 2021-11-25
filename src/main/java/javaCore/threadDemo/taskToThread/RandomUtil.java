package javaCore.threadDemo.taskToThread;

import java.util.Random;

/**
 * Создаем утилитный класс для генерации случайных чисел. И чтобы его никто не мог наследовать
 * делаем его public final class, так же чтобы нельзя было создать его обьект, делаем privat констр.
 */
public final class RandomUtil {
    private static final Random RANDOM = new Random();
    private static final int DEFAULT_BOUND = 10;

    private RandomUtil() {
    }

    public static int getRandom() {
        return RANDOM.nextInt(DEFAULT_BOUND);
    }

    public static int getRandom(int bound) {
        return RANDOM.nextInt(bound);
    }
}
