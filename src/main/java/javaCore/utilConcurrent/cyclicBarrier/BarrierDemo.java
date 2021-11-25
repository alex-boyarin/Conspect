package javaCore.utilConcurrent.cyclicBarrier;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(RocketDetail.values().length, () -> System.out.println("пуск"));
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Arrays.stream(RocketDetail.values())
                .map(detail -> new RocketDetailRunnable(detail, cyclicBarrier))
                .forEach(threadPool::submit);
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(1L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
