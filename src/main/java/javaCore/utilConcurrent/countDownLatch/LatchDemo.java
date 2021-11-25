package javaCore.utilConcurrent.countDownLatch;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Данная задача описывает как работает CountDownLatch-(обратный отсчет) или "зачелка"
 * Для этого создадим Enum RocketDetail, и в нем будет 5 частей ракеты. Далее создадим саму ракету
 * class Rocket которая будет реализовывать интерф. Runnable.
 * Теперь чтобы запустить нашу ракету только после того как будут готовы все наши детали нам
 * потребуется CountDownLatch, которую мы будем шарить между нашими потоками.
 */
public class LatchDemo {
    public static void main(String[] args) throws InterruptedException {
        /*
        Создаем защелку new CountDownLatch(int кол-во деталей) кол-во деталей будет равно длинне
        нашего enuma
         */
        CountDownLatch countDownLatch = new CountDownLatch(RocketDetail.values().length);
        ExecutorService executorService = Executors.newFixedThreadPool(3);//пул из 3 потоков

        executorService.submit(new Rocket(countDownLatch));

        Arrays.stream(RocketDetail.values())
                .map(detail -> new RocketDetailRunnable(detail, countDownLatch))
                .forEach(executorService::submit);
        executorService.shutdown();
        executorService.awaitTermination(1L, TimeUnit.MINUTES);
    }
}
