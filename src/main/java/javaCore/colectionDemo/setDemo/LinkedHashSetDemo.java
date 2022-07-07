package javaCore.colectionDemo.setDemo;

import java.util.LinkedHashSet;
import java.util.Set;

/* У Set нет метода sort, и так же при вызове Collections.sort() мы не можем передать
 * в него Set. И так как Set настолько отличается от List мы не можем получить значение по индексу
 * т.е. у нас нет метода get. И все что мы можем сделать это только пройтись итератором
 * по коллекции и посмотреть какие есть значения set.forEach */
public class LinkedHashSetDemo {
    public static void main(String[] args) {

        //Если нам нужен такой же порядок как при добавлении, то тогда нужно использовать LinkedHashSet<>
        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("h");
        linkedSet.add("h");//дубликаты не допускаются
        linkedSet.add("z");
        linkedSet.add("y");
        linkedSet.add("x");
        linkedSet.add("w");
        linkedSet.add("v");
        linkedSet.add("u");
        linkedSet.add("t");
        linkedSet.add("s");
        linkedSet.add("r");
        linkedSet.add("q");
        linkedSet.add("p");
        linkedSet.add("o");
        System.out.println(linkedSet);
    }
}