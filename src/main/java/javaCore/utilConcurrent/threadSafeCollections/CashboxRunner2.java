package javaCore.utilConcurrent.threadSafeCollections;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CashboxRunner2 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Cashbox2> cashboxs2 = new ArrayBlockingQueue<>(2, true, List.of(new Cashbox2(), new Cashbox2()));
        List<Thread> threads = Stream.of(
                        new BuyerThread2(cashboxs2),
                        new BuyerThread2(cashboxs2),
                        new BuyerThread2(cashboxs2),
                        new BuyerThread2(cashboxs2),
                        new BuyerThread2(cashboxs2),
                        new BuyerThread2(cashboxs2),
                        new BuyerThread2(cashboxs2),
                        new BuyerThread2(cashboxs2))
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
