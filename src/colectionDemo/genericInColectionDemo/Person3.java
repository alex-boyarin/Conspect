package colectionDemo.genericInColectionDemo;

/*
 * Дженерики в колекц. позволяет ограничить тип данных которые могут использоваться в колекц-ях. Это ограничение
 * одновременно позволяет расширить возможности этой коллекции при обработке именно этого типа данных.
 */
public class Person3 {
    private int personId;
    private String name = "";

    public Person3() {
    }

    public Person3(int personId) {
        this.personId = personId;
    }

    public Person3(String name) {
        this.name = name;
    }

    public Person3(int personId, String name) {
        this.personId = personId;
        this.name = name;
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
        return "Person3{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                '}';
    }
}
