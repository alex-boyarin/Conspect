package utilConcurrent.threadSafeCollections;

import java.util.concurrent.BlockingQueue;

/**
 * Первое что мы сделаем, это будем использовать потокабезопасн. коллекции BlockingQueue<>
 * Теперь модифицируем наш метод run() для этого пишем cashboxs2.take() который возвращает нашу кассу
 * take()-возвращает и удаляет из головы очереди, и ожидает если там не оказалось элемента, т.е. до тех
 * пор пока неокажется свободного элемента в нашей очереди он ожидает.
 */
public class BuyerThread2 implements Runnable {
    private final BlockingQueue<Cashbox2> cashboxs2;

    public BuyerThread2(BlockingQueue<Cashbox2> cashboxs2) {
        this.cashboxs2 = cashboxs2;
    }

    @Override
    public void run() {
        try {
            Cashbox2 cashbox = cashboxs2.take();//возвращает и удаляет из головы очереди
            System.out.println(Thread.currentThread().getName() + "-обслуживается в кассе-" + cashbox);
            Thread.sleep(5L);// этот метод для ожидания потока не обязателен, он всего лиш для демо.
            System.out.println(Thread.currentThread().getName() + "-освобождаю кассу-" + cashbox);
            cashboxs2.add(cashbox);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
