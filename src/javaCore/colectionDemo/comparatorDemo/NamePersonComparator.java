package javaCore.colectionDemo.comparatorDemo;

import java.util.Comparator;

public class NamePersonComparator implements Comparator<Person2> {
    @Override
    public int compare(Person2 o1, Person2 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
