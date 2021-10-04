package threadDemo.waitNotifyNotifyAll.without_waitNotifyNotifyAll;

import java.util.Queue;

/**
 * Сдесь нам необходимо получить свободную кассу, если бы у нас была всего одна касса то мы бы могли
 * сделать синхр.блок на нашей единственной кассе, и как только какой либо поток другой освобождал
 * монитор нашей кассы мы могли бы сразу же захватить этот монитор. Но дело в том что у нас
 * множество касс, таким образом мы не можем захватить монитор у всего нашего множества, нам
 * необходимо захватить монитор только у одной кассы. Мы должны проверить если !Cashbox не пуста
 * т.е. у нас есть свободная касса, следовательно можем взять эту кассу и в ней обслуживаться.
 * Но бывают случаи что два потока или больше, в одну единцу времени могут попытаься взять кассу,
 * и получается что одному из потоков может касса не достаться что приведет к ошибке
 * NoSuchElementException
 */
public class BuyerThread implements Runnable{
    private final Queue<Cashbox> cashboxes;//очередь касс в магазине

    public BuyerThread(Queue<Cashbox> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {

        try {
            while (true) {
                if (!cashboxes.isEmpty()) {// проверка на наличие свободной кассы
                    Cashbox cashbox = cashboxes.remove();//мы можем взять эту кассу
                    System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashbox);

                    Thread.sleep(2L);// время которое мы обслуживаемся. Поток который вызвал этот метод
//засыпает на кол-во милисекунд которое мы указали.
                    System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashbox);
                    cashboxes.add(cashbox);
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " ожидает свободную кассу");
                    Thread.sleep(2L);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
