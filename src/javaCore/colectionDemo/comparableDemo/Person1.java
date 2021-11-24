package javaCore.colectionDemo.comparableDemo;
/*
 * Для того чтобы не возникло ошибки времени выполнения нужно имплементировать интерфейс Comparable,
 * и реализовать его метод.
 */
public class Person1 implements Comparable<Person1> {
    private String name;
    private int id;

    public Person1() {

    }

    public Person1(int id) {
        this.id = id;
    }

    public Person1(String name) {
        this.name = name;
    }

    public Person1(String name, int id) {
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
    public int compareTo(javaCore.colectionDemo.comparableDemo.Person1 o) {
//        int result = -(id - o.id);// если поставить знак минус перед уравнением то сортировка будет по убыванию.
//        int value = 0;
//        if (result > 0) {
//            value = 1;
//        } else if (result < 0) {
//            value = -1;
//        }
//        return value;
        return name.compareTo(o.name);// Сортировка по имени.
    }
}
