package javaCore.javaIO.serializationDemo;

import javaCore.colectionDemo.genericInColectionDemo.Person;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    static String faculty = "MMF2";
    private String name;
    private int id;
    private transient String password;// временный, это поле не будет сериализовано
    private static final long serialVersionUID = 2L;

    //версия класса для серилизации, если ее изменить после сериализ. и запустить
    //для востановления обьекта то получим исключение.
    public Student(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "faculty= " + faculty + "\n" +
                " name= " + name + "\n" +
                " id= " + id + "\n" +
                " password= " + password;
    }
}
