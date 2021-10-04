package utilConcurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Первое что мы сделаем, это будем использовать потокабезопасн. коллекции BlockingQueue<>
 * Теперь модифицируем наш метод run() для этого пишем cashboxs2.take() который возвращает нашу кассу
 * take()-возвращает и удаляет из головы очереди, и ожидает если там не оказалось элемента, т.е. до тех
 * пор пока неокажется свободного элемента в нашей очереди он ожидает.
 */
public class BuyerThread3 implements Runnable {
    private final Semaphore cashboxs3;

    public BuyerThread3(Semaphore cashboxs3) {
        this.cashboxs3 = cashboxs3;
    }


    @Override
    public void run() {
        try {
            cashboxs3.acquire();//возвращает и удаляет из головы очереди

            System.out.println(Thread.currentThread().getName() + "-обслуживается в кассе-");
            Thread.sleep(5L);// этот метод для ожидания потока не обязателен, он всего лиш для демо.
            System.out.println(Thread.currentThread().getName() + "-освобождаю кассу-");
            cashboxs3.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
