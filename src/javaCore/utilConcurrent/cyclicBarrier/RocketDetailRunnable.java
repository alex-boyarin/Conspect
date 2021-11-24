package javaCore.utilConcurrent.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RocketDetailRunnable implements Runnable {
    private final RocketDetail rocketDetail;
    private final CyclicBarrier cyclicBarrier;

    public RocketDetailRunnable(RocketDetail rocketDetail, CyclicBarrier cyclicBarrier) {
        this.rocketDetail = rocketDetail;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Готовиться деталь: " + rocketDetail);
        try {
            Thread.sleep(1000L);
            System.out.println("Деталь готова и ожидает: " + rocketDetail);
            cyclicBarrier.await();
            System.out.println("деталь использованана " + rocketDetail);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
