package javaCore.colectionDemo.comparableDemo;

/* Для того чтобы не возникло ошибки времени выполнения нужно имплементировать интерфейс Comparable,
 * и реализовать его метод. */
public class Person implements Comparable<Person> {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Person{");
        stringBuilder.append("name='").append(name);
        stringBuilder.append(", id=").append(id).append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Person o) {
//        int result = -(id - o.id);// если поставить знак минус перед уравнением то сортировка будет по убыванию.
//        int value = 0;
//        if (result > 0) {
//            value = 1;
//        } else if (result < 0) {
//            value = -1;
//        }
//        return value;
        return Integer.valueOf(id).compareTo(o.id);// Сортировка по id, для сортировки примитивов их нужно обернуть.
        // return name.compareTo(o.name);//сортировка по имени.
    }
}
