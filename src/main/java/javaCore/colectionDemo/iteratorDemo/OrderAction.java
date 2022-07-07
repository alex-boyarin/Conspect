package javaCore.colectionDemo.iteratorDemo;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class OrderAction {
    public void discountAction(float bigAmount, List<Order> orders, int percent) {
        /* Далее извлекаем итератор из коллекции, итератор должен быть параметризован тем же типом, что и сама коллекция.
  Параметризация итератора позволяет получать доступ к объектам уже без всяких преобразований. */
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {//hasNext()-проверят существует ли текущий элем. на который указывает Iterator
            Order order = iterator.next();//next()-дает ссылку на этот текущий элем. и переключает iterator на следующую позицию.
            if (bigAmount >= order.getAmount()) {
                iterator.remove();//remove()- удаляет текущую позицию iterator
            } else {
                order.setAmount(order.getAmount() * (100 - percent) / 100.0);
            }
        }
        ListIterator<Order> listIterator = orders.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
            System.out.println(listIterator.nextIndex());//int nextIndex()-позволяет узнать индекс следующего элем.
        }
    }
}
