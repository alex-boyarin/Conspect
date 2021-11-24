package javaCore.colectionDemo.listDemo;

import java.util.ArrayList;
import java.util.List;

/*
 * List-Список это колекция которая состоит из набора нумерованных элементов.
 * Списки могут содержать повторяющиеся значения, а так же списки могут содержать значение Null.
 */
public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(7);
        list.add(42);
        list.add(null);
        list.add(42);
        list.add(77);
        System.out.println(list.size());//размер списка
        System.out.println(list);
        //В список можно добавлять в определенную позицию элементы. Используя следующий метод.
        list.add(5, 87);
        System.out.println(list);
        /*Извлечение: тут есть 2 метода по позиции и по типу объекта.
        Получение по индексу, если у нас есть элементы "null" то для предотвращения ошибки,
        требуется примитивные типы обернуть в обертку Integer, Double и так далее.*/
        Integer value = list.get(3);
        System.out.println(value);
        int value1 = list.indexOf(7);// Получение индекса элем.
        System.out.println(value1);
        list.remove(2);//Удаление индекса обьекта.
        list.remove(Integer.valueOf(42));//Удаление обьекта "42"
        System.out.println(list);
        // SubList-подсписок выводит элементы между заданными значениями.
        System.out.println(list.subList(1, 3));
    }
}
