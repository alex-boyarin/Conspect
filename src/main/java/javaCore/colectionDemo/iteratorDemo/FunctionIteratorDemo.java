package javaCore.colectionDemo.iteratorDemo;

import java.util.ArrayList;

/*
 * Методы iterator: boolean hasNext()-проверят существует ли текущий элем. на который указывает Iterator
 * E next()-дает ссылку на этот текущий элем. и переключает iterator на следущую позицию.
 * void remove()- удаляет текущую позицию iterator
 * boolean forEachRemaining(Consumer<?extends E>c)-выполняет действие над всеми оставшимися элем. которые iterator
 * еще не прошёл с помощью функционального интерфейса Consumer
 * <p>
 * ListIterator методы: int nextIndex()-позволяет узнать индекс следущего элем.
 * Boolean hasPrevious(), E previous(), int previousIndex()-возможность двигаться в обратном направлении по списку.
 * Void add(E e)-добавление элем.
 * void set(E e)-замена элем
 */
public class FunctionIteratorDemo {
    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>() {
            {
                add(new Order(234, 12.1));
                add(new Order(124, 3.0));
                add(new Order(254, 145.0));
                add(new Order(256, 2.0));
                add(new Order(752, 74.3));
            }
        };
        System.out.println(orders);
        float bigAmount = 10;
        int percent = 5;
        orders.removeIf(order -> order.getAmount() <= bigAmount);/*Метод  removeIf()-принимает предикат, который и задает условия.
        Предикат принимает текущий обьект колекция. order.getAmount() <= bigAmount- все обьекты для которых это условие будет true
        будут удалены */
        orders.forEach(order -> order.setAmount(order.getAmount() * (100 - percent) / 100));/* здесь уже передается другой функцИнтерфейс
        Consumer который будет выполнять действия над текущим элементом. Передается в качестве значения текущий обьект order */
        System.out.println(orders);
    }
}
