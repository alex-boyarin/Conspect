package javaCore.colectionDemo.setDemo;

import java.util.HashSet;
import java.util.Set;

/* У Set нет метода sort, и так же при вызове Collections.sort() мы не можем передать
 * в него Set. И так как Set настолько отличается от List мы не можем получить значение по индексу
 * т.е. у нас нет метода get. И все что мы можем сделать это только пройтись итератором
 * по коллекции и посмотреть какие есть значения set.forEach */
public class HashSetDemo {
    public static void main(String[] args) {
        // Наиболее используемая реализация Set-а позволяет избежать дупликации данных.
        // HashSet не сохраняет порядок добавления и не сортирует.
        Set<String> set = new HashSet<>();
        set.add("h");
        set.add("b");
        set.add("k");
        set.add("d");
        set.add("h");//дубликаты не допускаются
        set.add("z");
        set.add("y");
        set.add("x");
        set.add("w");
        set.add("v");
        set.add("u");
        set.add("t");
        set.add("s");
        set.add("r");
        set.add("q");
        set.add("p");
        set.add("o");
        System.out.println(set);
        System.out.println(set.add("a"));// если элемента в колекц. нет, то он добавится и вернет true
        System.out.println(set.add("b"));// если элемент уже есть то он не добавится и вернет false
        System.out.println(set.add("c"));
        System.out.println(set.add("d"));
        System.out.println(set.add("a"));
        set.forEach(System.out::println);
    }
}
