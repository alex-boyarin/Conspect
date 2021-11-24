package javaCore.colectionDemo.comparatorDemo;

import java.util.ArrayList;
import java.util.Collections;
/*
 * Сортировки выполняются не только Comparable но и Comparator. Версий использования Comparator существует несколько.
 * Основное назначение Comparator это ипользование для сравнение обьектов по какому либо признаку. Comparator реализуется
 * в 3 видах: внешний, как внутрений static class, и с помощью функционального интерфеса.
 * Рассмотрим первые 2 варианта.
 */
public class ComparatorDemo {
    public static void main(String[] args) {
        ArrayList<Person2> list = new ArrayList<>();
        list.add(new Person2(12, "Petya"));
        list.add(new Person2(125, "Misha"));
        list.add(new Person2(54, "Valodya"));
        list.add(new Person2(32, "Jak"));
        list.sort(new NamePersonComparator());// Первый вариант использования Comparator. Создается класс который имплементирует интерфейс
        //Comparator, интерфейс параметризуемый. Поэтому делаем параметризацию
        Collections.sort(list, new NamePersonComparator());// Второй вариант использования Comparator
        list.sort(new Person2.NameComparator());
        for (Person2 person2 : list) {
            System.out.println(person2);
        }

        /* Так же для реализации Comparator и для использ. логической связи, ипользуются static внутрение классы. в этом случае
        создается static внутрений класс.
         */
    }
}
