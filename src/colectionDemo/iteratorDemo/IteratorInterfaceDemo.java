package colectionDemo.iteratorDemo;

import java.util.ArrayList;

/* Методы iterator: boolean hasNext()-проверят существует ли текущий элем. на который указывает Iterator
E next()-дает ссылку на этот текущий элем. и переключает iterator на следущую позицию.
void remove()- удаляет текущую позицию iterator
boolean forEachRemaining(Consumer<?extends E>c)-выполняет действие над всеми оставшимися элем. которые iterator
 еще не прошол с помощью функционального интерфейса Consumer

 ListIterator методы: int nextIndex()-позволяет узнать индекс следущего элем.
 boolean hasPrevious(), E previous(), int previousIndex()-возможность двигаться в обратном направлении по списку.
 void add(E e)-добавление элем.
 void set(E e)-замена элем */
public class IteratorInterfaceDemo {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>() {
            {
                add(new Order(234, 12.1));
                add(new Order(124, 3.0));
                add(new Order(254, 145.0));
                add(new Order(256, 2.0));
                add(new Order(752, 74.3));
                /* Теперь с помощь iterator выберем из колекции те элем. сумма заказов которых превышает
       заданное число и сделаем на эти заказы сщщтветствующую заданную скидку. Для этого воспользуемся другим классом.*/
            }
        };
        System.out.println(orders);
        float bigAmount = 10;
        int percent = 5;
        OrderAction orderAction = new OrderAction();
        orderAction.discountAction(10, orders, percent);
        System.out.println(orders);
    }
}
