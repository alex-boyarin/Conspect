package jdbc_example.pojo;

import lombok.*;

import java.util.Objects;


public class Student {
    private int id;
    private String name;
    private String last_name;
    private double average_grade;

    public Student(int id, String name, String last_name, double average_grade) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.average_grade = average_grade;
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public double getAverage_grade() {
        return average_grade;
    }

    public void setAverage_grade(double average_grade) {
        this.average_grade = average_grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Double.compare(student.average_grade, average_grade) == 0 && name.equals(student.name) && last_name.equals(student.last_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, last_name, average_grade);
    }

    @Override
    public String toString() {
        return "Student{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", last_name='" + last_name + '\'' +
               ", average_grade=" + average_grade +
               '}';
    }
}
