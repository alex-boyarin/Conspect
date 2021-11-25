package javaCore.utilConcurrent.lock.task;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account1 {
    private static int generator = 1;
    /* создаем постоянную константу типа Lock, т.е. мы передаем ответств. за Lock монитора нашего
    каждого обьекта Account1 на другой обьект типа Lock */
    private final Lock lock = new ReentrantLock();//ReentrantLock()-реализация нашего интерфейса Lock
    private int id;
    private int money;

    public Account1(int money) {
        this.money = money;
        this.id = generator++;
    }

    public void add(int money) {
        this.money += money;
    }

    public boolean takeOff(int money) {
        if (this.money >= money) {
            this.money -= money;
            return true;
        }
        return false;
    }

    public Lock getLock() {// метод для того чтобы получать обьект этого Lock
        return lock;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
