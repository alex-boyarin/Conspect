package functionalPrograming;

import java.util.ArrayList;
import java.util.List;

public class StudentMap {
    private int age;
    private String name;
    private List<Integer> marks = new ArrayList<>();

    public StudentMap(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "StudentMap{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
