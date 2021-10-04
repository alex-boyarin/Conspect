package threadDemo.taskThread;

/**
 * 1. Создать класс Counter с одним полем:
 * privat int count
 * Добавить методы:
 * getCount()-для получения поля count
 * increment()-для увеличения значения поля на единицу
 * decrement()-для уменшения значения поля на единицу
 * <p>
 * 2. Создать класс CounterThread с одним полем и конструктором для инициализации:
 * privat Counter counter
 * в методе run() этого класса 100 раз вызвать counter.increment()
 * <p>
 * 3. В методе main создать 4 потока типа CounterThread, передав один и тот же обьект Counter
 * и запустить их, дождаться выполненения и вывестина консоль в текущее значение нашего счетчика
 * counter.getCount()
 */
public class Counter {
    private int count;

    public synchronized void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
