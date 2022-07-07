package javaCore.colectionDemo.genericInColectionDemo;

/* Дженерики в колекц. позволяет ограничить тип данных которые могут использоваться в колекц-ях. Это ограничение
 * одновременно позволяет расширить возможности этой коллекции при обработке именно этого типа данных. */
public class Person {
    private String name = "";
    private int personId;


    public Person() {
    }

    public Person(String name, int personId) {
        this.name = name;
        this.personId = personId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person {" +
               "personId=" + personId +
               ", name='" + name + '\'' +
               '}';
    }
}
