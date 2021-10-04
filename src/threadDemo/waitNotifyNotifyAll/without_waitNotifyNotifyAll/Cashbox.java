package threadDemo.waitNotifyNotifyAll.without_waitNotifyNotifyAll;

/**
 * class Cashbox не потока безопасный, потому-что если мы из двух разных потоков создадим
 * обьект типа Cashbox, у нас может быть две кассы с одинаковым идентификатором.
 * Но мы не будем Cashbox использовать в многопоточности, мы его лишь создадим в  main
 * т передадим в соответ. BuyerThread . Здесь еще переопределим toString.
 */
public class Cashbox {
    private static int generator = 1;
    private int id;

    public Cashbox() {
        this.id = generator++;
    }

    @Override
    public String toString() {
        return "Cashbox{" +
                "id=" + id +
                '}';
    }
}
