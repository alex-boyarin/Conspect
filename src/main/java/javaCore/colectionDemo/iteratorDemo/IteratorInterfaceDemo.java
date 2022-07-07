package javaCore.colectionDemo.iteratorDemo;

import java.util.ArrayList;

/* Методы iterator: boolean hasNext()-проверят существует ли текущий элем. на который указывает Iterator
 E next()-дает ссылку на этот текущий элем. и переключает iterator на следующую позицию.
 void remove()- удаляет текущую позицию iterator
 boolean forEachRemaining(Consumer<?extends E>c)-выполняет действие над всеми оставшимися элем. которые iterator
 еще не прошёл с помощью функционального интерфейса Consumer.
 ListIterator методы: int nextIndex()-позволяет узнать индекс следующего элем.
 boolean hasPrevious(), E previous(), int previousIndex()-возможность двигаться в обратном направлении по списку.
  */
public class IteratorInterfaceDemo {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>() {
            {
                add(new Order(234, 12.1));//add(E e)-добавление элем.
                add(new Order(124, 100));
                add(new Order(254, 145.0));
                add(new Order(256, 2.0));
                add(new Order(752, 74.3));
                set(3, new Order(111, 50));//set(E e)-замена элем.
            }
        };
        System.out.println(orders);
        float bigAmount = 10;
        int percent = 5;
              /* Теперь с помощью iterator выберем из коллекции те элем. сумма заказов которых превышает
       заданное число и сделаем на эти заказы заданную скидку. Для этого воспользуемся другим классом.*/
        OrderAction orderAction = new OrderAction();
        orderAction.discountAction(bigAmount, orders, percent);
        System.out.println(orders);
    }
}
