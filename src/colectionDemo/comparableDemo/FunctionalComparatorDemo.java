package colectionDemo.comparableDemo;

import colectionDemo.comparatorDemo.Person2;

import java.util.ArrayList;
import java.util.Comparator;

public class FunctionalComparatorDemo {
    public static void main(String[] args) {
        ArrayList<Person2> list = new ArrayList<>();
        list.add(new Person2(12, "Petya"));
        list.add(new Person2(42, "Petya"));
        list.add(new Person2(125, "Jak"));
        list.add(new Person2(54, "Jak"));
        list.add(new Person2(32, "Jak"));
        //list.sort((o1, o2) -> o1.getId()- o2.getId());//Использование лямда выражений.
        // Зачастую бывает необходимо выполнить одну сортировку внутри другой.
        list.sort(Comparator.comparing((Person2 person2) -> person2.getName()).thenComparing(Person2::getId));
        for (Person2 person2 : list) {
            System.out.println(person2);
        }

    }
}
