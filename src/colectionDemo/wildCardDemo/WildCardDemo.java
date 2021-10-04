package colectionDemo.wildCardDemo;

import colectionDemo.genericInColectionDemo.Person3;
import colectionDemo.genericInColectionDemo.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
 Метасимвол ? в параметризации методов позволяет реализовать списки классов наследников, и супер класса.
 */
public class WildCardDemo {
    public static void main(String[] args) {
        List<Person3> list = new ArrayList<>();
        list.add(new Person3());
        //list.add(new Student());
        action(list);
        List<Student> students = new ArrayList<>();
        students.add(new Student());
        action(students);
    }

    /*
    Для того чтобы метод параметризованный <Person1> мог принимать списки и его наследников,
    для этого следует использовать символ "?"- этот символ обозначает что любой подкласс от супер класс
    может передаваться в метод
     */
    static void action(List<? extends Person3> list) {
        list.remove(0);//удалять можно.
        //list.add(new Person()) //добавлять нельзя.
        Stream<? extends Person3> stream = list.stream();//так же такой список может быть преобразован
        // в Stream но параметризация должна точно совпадать с параметризацией списка.
    }
}
