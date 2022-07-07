package javaCore.colectionDemo.comparatorDemo;

import java.util.Comparator;

public class Person {
    private String name;
    private int id;

    public Person() {
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Person{");
        stringBuilder.append("name='").append(name);
        stringBuilder.append(", id=").append(id).append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    /* Так же для реализации Comparator и для использ. логической связи, используются static внутренние классы.
    В этом случае создается static внутренний класс. Он будет связан с самим классом при объявлении. */
    public static class NameComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
