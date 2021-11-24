package javaCore.colectionDemo.comparableDemo;

import java.util.TreeSet;

/*
 * Интерфейс Comparable используется в случае если необходимо сравнивать объекты целиком.
 * Он имеет непосредственное отношение к коллекции, его можно использовать как основу для добавления
 * в сортированые множества. Больше всего для таких действий применяется comparator, т.к. когда у класса много
 * полей создается comparator для сортировки по каждому полю по отдельности, либо по необходимым полям.
 * Comparable предпологает сравнение обьектов целиком, т.к. имплементирует его сам класс. В этом случае
 * из реальных классов стандартной java (к ним относятся все классы оболочки над базовым типом и класс String
 * где сравнениe cтрок целеком проводится по коду символа), если это слова одного языка, соответств. они распологаются
 * в словарном порядке. Но тем не мене интерфейс Comparable можно в частных случаях использовать для работы с TreeSet
 * с множеством упорядоченым которое в общем то этот  Comparable использует.
 */
public class ComparableDemo {
    public static void main(String[] args) {
        TreeSet<Person1> treeSet = new TreeSet<>();
        treeSet.add(new Person1("Petya", 12));
        treeSet.add(new Person1("Misha", 125));
        treeSet.add(new Person1("Valodya", 54));
        treeSet.add(new Person1("Jak", 32));
        treeSet.add(new Person1("Ja",32));
        for (Person1 person1 : treeSet) {
            System.out.println(person1);
        }
    }
}
