package javaCore.colectionDemo.comparatorDemo;

import java.util.Comparator;

public class Person2 {
    private int id;
    private String name;

    public Person2() {
    }

    public Person2(int id) {
        this.id = id;
    }

    public Person2(String name) {
        this.name = name;
    }

    public Person2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /* Так же для реализации Comparator и для использ. логической связи, ипользуются static внутрение классы.
              в этом случае создается static внутрений класс. Он будет связан с самим классом при обьявлении. */
    public static class NameComparator implements Comparator<Person2> {

        @Override
        public int compare(Person2 o1, Person2 o2) {
            return o1.getName().compareTo(o2.getName());
        }
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
}
