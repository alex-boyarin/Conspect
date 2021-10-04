package threadDemo.withWaitNotifyNotifyAll;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Ошибку из предыдущего примера будем решать при помощи методов wait(), notify(), notifyAll()
 * 1 что мы должны сделать это захватить монитор  synchronized (cashbox1s) наших касс,
 * перед тем как мы вызовем метод isEmpty() у нашей колекции, таким образ. только один поток
 * может проверить свободность касс у наших cashbox1s. И теперь у нас не будет таких проблем,
 * и никогда не будет NoSuchElementException.
 * <p>
 * Но на самом деле этого не достаточно чтобы коректно решить нашу проблему. Дело в том что метод
 * Thread.sleep() останавливает поток на определен. кол-во времени, которое мы передаем как параметр,
 * и он не освобождает монитор который мы захватили, а это не совсем правельно,
 * ведь когда мы захватываем монитор всех наших касс, а используем мы только одну кассу,
 * таким образом мы должны освободить монитор всех наших касс пока мы обслуживаемся в одной cashbox1.
 * Таким образом есть аналог нашего sleep() и отличие только в том, что мы должны вызвать этот метод
 * у обьекта монитор которого мы захватили, в данном случае это cashbox1s.wait(2L) и передать туда
 * кол-во милисекунд которое мы хотим ждать, метод wait() вызывается только в составе синхрониз.
 * метода или блока, т.к. сам он не синхронизирован.
 * Так же мы должны во время того как мы ждем освобождения наших касс, так же вызвать у cashbox1s.wait
 * но теперь мы не передаем кол-во милисек. которое мы должны ждать потому-что покупатель не знает
 * как долго ему придется ждать, по другому как долго будет обслуживаться другой покупатель в кассе,
 * следовательно мыы должны ждать до тех пор пока касса не освободиться, тогда вопрос как долго мы
 * должны ждать? Мы будем ждать до тех пот пака другой поток не вызовет у того же самого обьекта
 * у которого мы вызвали метод .wait() методы notify() либо notifyAll()
 * Значит мы на том же самом обьекте в котором только что обслужились вызываем
 * метод notify() либо notifyAll()
 */
public class CashboxRunner1 {
    public static void main(String[] args) throws InterruptedException {
        Queue<Cashbox1> cashbox1s = new ArrayDeque<>(List.of(new Cashbox1(), new Cashbox1()));
        List<Thread> threads = Stream.of(new BuyerThread1(cashbox1s),
                        new BuyerThread1(cashbox1s),
                        new BuyerThread1(cashbox1s),
                        new BuyerThread1(cashbox1s),
                        new BuyerThread1(cashbox1s),
                        new BuyerThread1(cashbox1s),
                        new BuyerThread1(cashbox1s),
                        new BuyerThread1(cashbox1s))
                .map(Thread::new)
                .peek(Thread::start)
                .collect(Collectors.toList());
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
