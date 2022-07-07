package javaCore.colectionDemo.comparatorDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* Сортировки выполняются не только Comparable, но и Comparator. Версий использования Comparator существует несколько.
 * Основное назначение Comparator это использование для сравнения объектов по какому-либо признаку. Comparator реализуется
 * в 3 видах:
 * 1) Внешний;
 * 2) Как внутренний static class;
 * 3) С помощью функционального интерфейса.
 * Рассмотрим первые 2 варианта. */
public class ComparatorDemo {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Petya", 12));
        list.add(new Person("Misha", 125));
        list.add(new Person("Valodya", 54));
        list.add(new Person("Jak", 32));

        /* 1) вариант использования Comparator. Создается класс который имплементируют интерфейс
        Comparator, интерфейс параметризуемый. Поэтому делаем параметризацию. */
        list.sort(new NamePersonComparator());
        Collections.sort(list, new NamePersonComparator());//идентичные варианты этот и предыдущий
        for (Person person : list) {
            System.out.println(person);
        }

        /* 2) вариант использования Comparator. Как внутренний static class. */
        list.sort(new Person.NameComparator());
        for (Person person : list) {
            System.out.println(person);
        }

        /* 3) С помощью функционального интерфейса. */
        //list.sort(Comparator.comparing(Person::getName)); //так тоже можно записать.
        list.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
