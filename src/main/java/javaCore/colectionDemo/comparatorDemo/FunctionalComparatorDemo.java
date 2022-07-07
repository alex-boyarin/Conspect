package javaCore.colectionDemo.comparatorDemo;

import java.util.ArrayList;
import java.util.Comparator;

public class FunctionalComparatorDemo {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Petya",12 ));
        list.add(new Person("Petya",42 ));
        list.add(new Person("Jak",125 ));
        list.add(new Person("Jak",54 ));
        list.add(new Person("Jak",32 ));
        list.sort((o1, o2) -> o1.getId()- o2.getId());//Использование лямбда выражений.

        // Зачастую бывает необходимо выполнить одну сортировку внутри другой.
        list.sort(Comparator.comparing((Person person) -> person.getName()).thenComparing(Person::getId));
        for (Person person : list) {
            System.out.println(person);
        }

    }
}
