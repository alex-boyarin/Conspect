package javaCore.colectionDemo.genericInColectionDemo;

import java.util.ArrayList;
import java.util.List;

/* В список можно добавить объекты только того типа, что указаны в параметризации List<Student> list.
Если попытаться добавить другой тип – то будет ошибка. */
public class GenericDemo {
    public static void main(String[] args) {
        /* если список параметризован наследником то, добавить
        объект из супер класса не получится, будет ошибка!!! */
        List<Student> list1 = new ArrayList<>();
        //list.add(new Person())-Ошибка!!!
        list1.add(new Student());
        list1.add(new Student());

        /*если параметризация будет родительским классом, то
        добавить объект наследника не составит труда.*/
        List<Person> list2 = new ArrayList<>();
        list2.add(new Student());
        list2.add(new Student());

        //list1.add("ддд"); - здесь будет ошибка!
        /* Так же у нас есть супер класс Person если попытаться добавить его будет так же ошибка!!!
        list1.add(new Person()); Для того чтобы можно было добавлять супер класс нам нужно изменить
        параметризацию List<Person> list- тогда ошибки не будет. */
        List<Person> personList = new ArrayList<>();
        personList.add(new Person());

        /* При извлечении этого обьекта метод get() возвращает ссылку на родительский класс, причем не важно
        будет в списке родитель или наследник. Т.е. всегда будет возвращаться тип параметризации.
        Если нужно добраться до наследника, то придется возвращенный тип преобразовывать к наследнику */
        Person person = list2.get(2);
        System.out.println(person);
    }
}
