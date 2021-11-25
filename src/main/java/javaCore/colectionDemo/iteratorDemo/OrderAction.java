package javaCore.colectionDemo.iteratorDemo;

import java.util.Iterator;
import java.util.List;

public class OrderAction {
    public void discountAction(float bigAmount, List<Order> orders, int percent) {
        /* Далее извлекаем итератор из колекции, итератор должен быть параметризован темже типом что и сама колекция.
  Параметризация итератора позволяет получать доступ к обьектам уже без всяких преобразований. */
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order order = iterator.next();
            if (bigAmount >= order.getAmount()) {
                iterator.remove();
            } else {
                order.setAmount(order.getAmount() * (100 - percent) / 100.0);
            }
        }
    }
}
