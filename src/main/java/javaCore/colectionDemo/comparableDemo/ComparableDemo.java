package javaCore.colectionDemo.comparableDemo;

import java.util.TreeSet;

/*
 * Интерфейс Comparable используется в случае если необходимо сравнивать объекты целиком.
 * Он имеет непосредственное отношение к коллекции, его можно использовать как основу для добавления
 * в сортированные множества. Больше всего для таких действий применяется comparator, т.к. когда у класса много
 * полей создается comparator для сортировки по каждому полю по отдельности, либо по необходимым полям.
 * Comparable предполагает сравнение объектов целиком, т.к. имплементируют его сам класс. В этом случае
 * из реальных классов стандартной java (к ним относятся все классы оболочки над базовым типом и класс String,
 * где сравнение строк целиком проводится по коду символа), если это слова одного языка, соответств. они располагаются
 * в словарном порядке. Но тем не мене интерфейс Comparable можно в частных случаях использовать для работы с TreeSet
 * с множеством упорядоченным которое в общем то этот Comparable использует.
 */
public class ComparableDemo {
    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person("Petya", 12));
        treeSet.add(new Person("Misha", 125));

        treeSet.add(new Person("Valodya", 54));
        treeSet.add(new Person("Jak", 32));
        treeSet.add(new Person("Ja", 22));
        treeSet.add(new Person("Ja", 33));/*дублирование не допустимо!!! Как целиком записи, так и частично
        но при частичном дублировании если сравнение происходит по уникальному элементу, то дублирование пройдет
        например treeSet.add(new Person("Ja", 33)) здесь при сравнение по id эта запись пройдет, а при сравнении по
        name она не добавиться в список так как такая запись уже есть*/
        for (Person person : treeSet) {
            System.out.println(person);
        }
    }
}
