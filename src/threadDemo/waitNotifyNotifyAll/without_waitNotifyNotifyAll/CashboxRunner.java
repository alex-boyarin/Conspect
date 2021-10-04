package threadDemo.waitNotifyNotifyAll.without_waitNotifyNotifyAll;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Пример очереди в магазин, т.е. у нас есть кассы-это ограниченный ресурс, и покупатели-это потоки.
 * Сделаем несколько касс и множество покупателей, таким образом создадим дефицит касс, и покупатели
 * будут ждать в очереди.
 * <p>
 * Но бывают случаи когда два потока или больше, в одну единцу времени могут попытаься взять кассу,
 * и получается что одному из потоков может касса не достаться что приведет к ошибке
 * NoSuchElementException в следущем примере мы попробуем решить эту проблему с помощью wait, notify
 */
public class CashboxRunner {
    public static void main(String[] args) throws InterruptedException {
        /**
         * В методе main где у нас будет несколько касс Cashbox.
         * Далее создаем Stream.of () и в нем создадим наших BuyerThread() и в каждый из этих потоков
         * передаем общий ресурс ресурс cashboxes.
         */
        Queue<Cashbox> cashboxes = new ArrayDeque<>(List.of(new Cashbox(), new Cashbox()));
        List<Thread> threads = Stream.of(
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes),
                        new BuyerThread(cashboxes))
                /**
                 * Далее т.к. class BuyerThread implements Runnable реализ. интерф. т.е. он не самостоят.
                 * следовательно каждый из них нам необходимо преобразовать преобразовать в Thread,
                 * после этого их необходимо стартануть, методом peek(Thread::start)
                 * Далее у нас есть список наших потоков collect(Collectors.toList()), и все что нам
                 * необходимо сделать это взять итератор и у thread вызовем метод join().
                 */
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
