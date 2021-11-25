package javaCore.utilConcurrent.semaphore;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CashboxRunner3 {
    public static void main(String[] args) throws InterruptedException {
        //BlockingQueue<Cashbox2> cashboxs2 = new ArrayBlockingQueue<>(2, true, List.of(new Cashbox2(), new Cashbox2()));
        Semaphore cashboxs3 = new Semaphore(2);
        List<Thread> threads = Stream.of(
                        new BuyerThread3(cashboxs3),
                        new BuyerThread3(cashboxs3),
                        new BuyerThread3(cashboxs3),
                        new BuyerThread3(cashboxs3),
                        new BuyerThread3(cashboxs3),
                        new BuyerThread3(cashboxs3),
                        new BuyerThread3(cashboxs3),
                        new BuyerThread3(cashboxs3))
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
